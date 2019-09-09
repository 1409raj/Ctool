var app = angular.module("app", [ 'ui.router','ng']);

/*var image1;
app.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					image1 = element[0].files[0];
					alert(element[0].files[0]);

				});
			});
		}
	};
} ]);
*/


app.directive('onlyDigits', function () {
    return {
      require: 'ngModel',
      restrict: 'A',
      link: function (scope, element, attr, ctrl) {
        function inputValue(val) {
          if (val) {
            var digits = val.replace(/[^0-9.]/g, '');

            if (digits.split('.').length > 2) {
              digits = digits.substring(0, digits.length - 1);
            }

            if (digits !== val) {
              ctrl.$setViewValue(digits);
              ctrl.$render();
            }
            return parseFloat(digits);
          }
          return undefined;
        }            
        ctrl.$parsers.push(inputValue);
      }
    };
 });
var image1;
var image = [];

app.factory('ServicePDF', function ($http) {
    return {
        downloadPdf: function () {
        return $http.get('/Ctool/employee/getEmployeePDF', { responseType: 'arraybuffer' }).then(function (response) {
            return response;
        });
    }
};
});
//app.factory('ServicePDF1', function ($http) {
//    return {
//        downloadPdf: function () {
//        return $http.get('/Ctool/employee/getSinglePdf?ID=830', { responseType: 'arraybuffer' }).then(function (response) {
//            return response;
//        });
//    }
//};
//});

app.factory('ServiceWord', function($http){
	return{
		downloadWord: function(){
			return $http.get('/Ctool/employee/getEmployeeWord', { responseType : 'arraybuffer'}).then(function(response){
				return response;
			});
		}
	};
});

app.filter('numberEx', ['numberFilter', '$locale',
	  function(number, $locale) {

	    var formats = $locale.NUMBER_FORMATS;
	    return function(input, fractionSize) {
	      //Get formatted value
	      var formattedValue = number(input, fractionSize);

	      //get the decimalSepPosition
	      var decimalIdx = formattedValue.indexOf(formats.DECIMAL_SEP);

	      //If no decimal just return
	      if (decimalIdx == -1) return formattedValue;


	      var whole = formattedValue.substring(0, decimalIdx);
	      var decimal = (Number(formattedValue.substring(decimalIdx)) || "").toString();

	      return whole +  decimal.substring(1);
	    };
	  }
	]);


app.filter('intconvert', ['numberFilter', '$locale',
	  function(number, $locale) {

	    var formats = $locale.NUMBER_FORMATS;
	    return function(input, fractionSize) {
	    	
	      return parseInt(formats);
	    };
	  }
	]);



app.filter('dayTomonth', function() {
    return function(total_days) {

    	
	    //var total_days = 1001;
	    var date_current = new Date();
	    var utime_target = date_current.getTime() + total_days*86400*1000;
	    var date_target = new Date(utime_target);

	    var diff_year  = parseInt(date_target.getUTCFullYear() - date_current.getUTCFullYear());
	    var diff_month = parseInt(date_target.getUTCMonth() - date_current.getUTCMonth());
	    var diff_day   = parseInt(date_target.getUTCDate() - date_current.getUTCDate());

	    var days_in_month = [31, (date_target.getUTCFullYear()%4?29:28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	    var date_string = "";
	    while(true)
	    {
	        date_string = "";
	        date_string += (diff_year>=0?diff_year + " Y,":"");

	        if(diff_month<0){diff_year -= 1; diff_month += 12; continue;}
	        date_string += (diff_month>0?diff_month + " M,":"");

	        if(diff_day<0){diff_month -= 1; diff_day += days_in_month[((11+date_target.getUTCMonth())%12)]; continue;}
	        date_string += (diff_day>0?diff_day + " D":"");
	        break;
	    }
	    
	    return date_string;
	    console.log(date_string);
	
    	
    	
    };
    
    
    
});


app.filter('dayTomonthwithoutSymbol', function() {
    return function(total_days) {

    	
	    //var total_days = 1001;
	    var date_current = new Date();
	    var utime_target = date_current.getTime() + total_days*86400*1000;
	    var date_target = new Date(utime_target);

	    var diff_year  = parseInt(date_target.getUTCFullYear() - date_current.getUTCFullYear());
	    var diff_month = parseInt(date_target.getUTCMonth() - date_current.getUTCMonth());
	    var diff_day   = parseInt(date_target.getUTCDate() - date_current.getUTCDate());

	    var days_in_month = [31, (date_target.getUTCFullYear()%4?29:28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	    var date_string = "";
	    while(true)
	    {
	        date_string = "";
	        date_string += (diff_year>=0?diff_year + ",":"");

	        if(diff_month<0){diff_year -= 1; diff_month += 12; continue;}
	        date_string += (diff_month>=0?diff_month + ",":"");

	        if(diff_day<0){diff_month -= 1; diff_day += days_in_month[((11+date_target.getUTCMonth())%12)]; continue;}
	        date_string += (diff_day>=0?diff_day + " ":"");
	        break;
	    }
	    
	    return date_string;
	    console.log(date_string);
	
    	
    	
    };
    
    
    
});

app.directive('fileModel', [ '$parse', function($parse) {
	return {
		restrict : 'A',
		link : function(scope, element, attrs) {
			var model = $parse(attrs.fileModel);
			var modelSetter = model.assign;

			element.bind('change', function() {
				scope.$apply(function() {
					image = element[0].files;
					image1 = element[0].files[0];
					console.log(element[0].files);

				});
			});
		}
	};
} ]);


// Service used to share data across controllers
app.service('sharedProperties', function() {
	var hashtable = {};
	return {
		setValue : function(key, value) {
			hashtable[key] = value;
		},
		getValue : function(key) {
			return hashtable[key];
		}
	}
});

app.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/viewemployee');

	$stateProvider.state('main', {
		url : '/main',
		templateUrl : 'main',
		controller : 'mainController'
	})

	.state('employee', {
		url : '/employee',
		templateUrl : 'employee',
		controller : 'employeeController'
	})

		.state('viewemployee', {
		url : '/viewemployee',
		templateUrl : 'viewemployee',
		controller : 'viewemployeeController'
	})

	
	
	.state('configuration', {
		url : '/configuration',
		templateUrl : 'configuration',
		controller : 'configurationController'
	})

	.state('employee_bulk', {
		url : '/employee_bulk',
		templateUrl : 'employee_bulk',
		controller : 'employeebulkController'
	})

	.state('viewconfiguration', {
		url : '/viewconfiguration',
		templateUrl : 'viewconfiguration',
		controller : 'viewconfigurationClientController'
	})
	
	
		.state('config', {
		url : '/config',
		templateUrl : 'config',
		controller : 'configController'
	})



	.state('edit_meeting', {
		url : '/edit_meeting',
		templateUrl : 'edit_meeting',
		controller : 'editmeetingController'
	})




	
	.state('employeeFinalCalculation', {
		url : '/employeeFinalCalculation',
		templateUrl : 'employeeFinalCalculation',
		controller : 'EmployeeFinalCalculationController'
	})


	.state('employee_basic_details_bulk', {
		url : '/employee_basic_details_bulk',
		templateUrl : 'employee_basic_details_bulk',
		controller : 'EmployeeBasicDetailsController'
	}).state('employee_list', {
		url : '/employee_list',
		templateUrl : 'employee_list',
		controller : 'EmployeeListController'
	}).state('viewGeneratedPDf', {
		url : '/viewGeneratedPDf',
		templateUrl : 'viewGeneratedPDf',
		controller : 'ViewGeneratedPDfController'
	})

	.state('addSlab', {
		url : '/addSlab',
		templateUrl : 'addSlab',
		controller : 'addSlabController'
	}).state('viewSlab', {
		url : '/viewSlab',
		templateUrl : 'viewSlab',
		controller : 'viewSlabController'
	})
	
	.state('viewVariablenonrooftop', {
		url : '/viewVariablenonrooftop',
		templateUrl : 'viewVariablenonrooftop',
		controller : 'viewVariablenonrooftopController'
			
	})
	.state('addVariablenonrooftop', {
		url : '/addVariablenonrooftop',
		templateUrl : 'addVariablenonrooftop',
		controller : 'addVariablenonrooftopController'
			
	})
	
	
	.state('viewVariablenonrooftop33', {
		url : '/viewVariablenonrooftop33',
		templateUrl : 'viewVariablenonrooftop33',
		controller : 'viewVariablenonrooftop33Controller'
			
	})
	.state('addVariablenonrooftop33', {
		url : '/addVariablenonrooftop33',
		templateUrl : 'addVariablenonrooftop33',
		controller : 'addVariablenonrooftop33Controller'
			
	})
	
	
	.state('addVariablerooftop', {
		url : '/addVariablerooftop',
		templateUrl : 'addVariablerooftop',
		controller : 'addVariablerooftopController'
			
	})
	
	.state('editVariable', {
		url : '/editVariable',
		templateUrl : 'editVariable',
		controller : 'editVariableController'
	})
	.state('details', {
		url : '/details',
		templateUrl : 'details',
		controller : 'detailsController'
	})
	
		.state('addincVariable', {
		url : '/addincVariable',
		templateUrl : 'addincVariable',
		controller : 'addincVariableController'
	})
	
	.state('editincVariable', {
		url : '/editincVariable',
		templateUrl : 'editincVariable',
		controller : 'editincVariableController'
	})
	

	.state('viewincVariable', {
		url : '/viewincVariable',
		templateUrl : 'viewincVariable',
		controller : 'viewincVariableController'
	})
	
	.state('addEmpVariableroofTop', {
		url : '/addEmpVariableroofTop',
		templateUrl : 'addEmpVariableroofTop',
		controller : 'addEmpVariableroofTopController'
	})
});



app.controller("addEmpVariableroofTopController", function($scope, $http, $timeout,sharedProperties,$window) {
	

	$scope.init=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
		var res = $http.post('/Ctool/variable/ratingEmployeeRoofTop');
		res.success(function(data, status) {
			Swal.close();
			 $scope.employeeVariblelistRoofTop = data.object;
		});
	
	
	}
	
	
	$scope.edit=function(data)
	{
		$scope.vars=data;
	}
	
	
	$scope.vars={
			"ratMin":"1",
			"ratMax":"1"
	}
	
	$scope.addEmployeeRatingVariableRoofTop=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		
		var data=$scope.vars;
		
	
		 $http({
		        method : "POST",
		        url : "/Ctool/variable/saveEmployeeVariableRoofTop",
		        data:data
		    }).then(function mySuccess(response) {
		    	Swal.close();
		        $scope.employeeVaribleRoofTop = response.data;
		        $scope.employeeVariblelistRoofTop = response.data.object;
		       if( $scope.employeeVaribleRoofTop.status)
		        	{
		        	$scope.vars=null;
		        	Swal.fire(
		        			  'Success',
		        			  'Variable  created Successfully',
		        			  'success'
		        			)
		        	
		        	}
		        else
		        	{
		        	Swal.fire("Failed", "Something went wrong", "error");
		        	}
		        
		    }, function myError(response) {
		        $scope.myWelcome = response.statusText;
		    });
			
	}

});

app.controller("addVariablerooftopController", function($scope, $http, $timeout,sharedProperties,$window) {

	

	$scope.init=function()
	{

		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
		var res = $http.post('/Ctool/variable/listRoofTop40');
		res.success(function(data, status) {
			Swal.close();
			 $scope.ratingvariableListRooftop = data.object;
		});
	
	}
	
	
	$scope.edit=function(data)
	{
		$scope.vars=data;
	}
	
	
	$scope.addRoofTopVariable=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		
		var data=$scope.vars;
		
	
		 $http({
		        method : "POST",
		        url : "/Ctool/variable/saveRooftop",
		        data:data
		    }).then(function mySuccess(response) {
		    	Swal.close();
		        $scope.roofTopStatus = response.data;
		        $scope.ratingvariableListRooftop=response.data.object;
		        if( $scope.roofTopStatus.status)
		        	{
		        	$scope.vars=null;
		        	Swal.fire(
		        			  'Success',
		        			  'Variable  created Successfully',
		        			  'success'
		        			)
		        	
		        	}
		        else
		        	{
		        	Swal.fire("Failed", "Something went wrong", "error");
		        	}
		        
		    }, function myError(response) {
		        $scope.myWelcome = response.statusText;
		    });
			
	}
	

	
	

});


app.controller("addVariablenonrooftop33Controller", function($scope, $http, $timeout,sharedProperties,$window) {
	

	$scope.init=function()
	{

		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
		var res = $http.post('/Ctool/variable/listnonRoofTop');
		res.success(function(data, status) {
			Swal.close();
			 $scope.ratingvariableListnonRooftop = data.object;
		});
	
	}
	
	
	$scope.edit=function(data)
	{
		$scope.vars=data;
	}
	
	
	$scope.addnonRoofTopVariable=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		
		var data=$scope.vars;
		
	
		 $http({
		        method : "POST",
		        url : "/Ctool/variable/savenonRooftop",
		        data:data
		    }).then(function mySuccess(response) {
		    	Swal.close();
		        $scope.nonroofTopStatus = response.data;
		        $scope.ratingvariableListnonRooftop=response.data.object;
		        if( $scope.nonroofTopStatus.status)
		        	{
		        	$scope.vars=null;
		        	Swal.fire(
		        			  'Success',
		        			  'Variable  created Successfully',
		        			  'success'
		        			)
		        	
		        	}
		        else
		        	{
		        	Swal.fire("Failed", "Something went wrong", "error");
		        	}
		        
		    }, function myError(response) {
		        $scope.myWelcome = response.statusText;
		    });
			
	}
	
});

app.controller("viewVariablenonrooftop33Controller", function($scope, $http, $timeout,sharedProperties,$window) {
});



app.controller("addincVariableController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.inc={
			"ratMin":1,
			"ratMax":1
	}
	
	$scope.incrementVariableInit=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
		var res = $http.post('/Ctool/increment/list');
		res.success(function(data, status) {
			Swal.close();
			$scope.ratingvariableList = data.object;
		});
	}
	
	$scope.addincVariableRating=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		
		var data=$scope.inc;
		
	
		 $http({
		        method : "POST",
		        url : "/Ctool/increment/save",
		        data:data
		    }).then(function mySuccess(response) {
		    	Swal.close();
		    	$scope.inc=null;
		        $scope.incrementStatus = response.data;
		        $scope.ratingvariableList = response.data.object;
		        if( $scope.incrementStatus.status)
		        	{
		        	Swal.fire(
		        			  'Success',
		        			  'Rating  created Successfully',
		        			  'success'
		        			)
		        	
		        	}
		        else
		        	{
		        	Swal.fire("Failed", "Something went wrong", "error");
		        	}
		        
		    }, function myError(response) {
		        $scope.myWelcome = response.statusText;
		    });
			
	}

	$scope.editincVariable=function(data)
	{
		$scope.inc=data;
	}

	
});



app.controller("editincVariableController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.inc = sharedProperties.getValue("incrementVariableData");
	
	if($scope.inc==undefined)
		{
		$window.location.href = '#/viewincVariable';
		}
	
	$scope.addincVariableRating=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		
		var data=$scope.inc;
		
	
		 $http({
		        method : "POST",
		        url : "/Ctool/increment/save",
		        data:data
		    }).then(function mySuccess(response) {
		    	Swal.close();
		        $scope.incrementStatus = response.data;
		        if( $scope.incrementStatus.status)
		        	{
		        	Swal.fire(
		        			  'Success',
		        			  'Increment Rating  updated Successfully',
		        			  'success'
		        			)
		        			$window.location.href = '#/viewincVariable';
		        	}
		        else
		        	{
		        	Swal.fire("Failed", "Something went wrong", "error");
		        	}
		        
		    }, function myError(response) {
		        $scope.myWelcome = response.statusText;
		    });
			
	}
	

	
	
	
	


	

	
});

app.controller("viewincVariableController", function($scope, $http, $timeout,sharedProperties,$window) {
	

	
	$scope.incrementVariableInit=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
		var res = $http.post('/Ctool/increment/list');
		res.success(function(data, status) {
			Swal.close();
			$scope.ratingvariableList = data.object;
		});
	}
	
	$scope.editincVariable=function(editdata)
	{
		$window.location.href = '#/editincVariable';
		sharedProperties.setValue("incrementVariableData", editdata);
	}
	

	
});



app.controller("detailsController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	
	$scope.getDataOnLoad = function() {
		
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		
		var res = $http.post('/Ctool/employee/employeeList');
		res.success(function(data, status) {
			 Swal.close();
			$scope.employeeListData = data.object;
			
			$(document).ready(function() {
			    var table = $('#example').DataTable( {
			        scrollX:        true,
			        scrollCollapse: true,
			        paging:         true,
			        orderCellsTop: true,
			         fixedHeader: true,
			         /*scrollY: 500,*/
			        dom: 'Bfrtip',
			        buttons: [
			            {
			                extend: 'csv',
			                footer: false,
			              
			               
			            },
			            {
			                extend: 'excel',
			                footer: false,
			               
			            }         
			         ],
			        fixedColumns:   {
			            leftColumns: 6
			            
			        }
			    
			    
			    } );
			} );
			
		});
	}
	
	
	
});

app.controller("mainController", function($scope, $http, $timeout,sharedProperties,$window) {
	$scope.getDataOnLoad = function() {
		var res = $http.post('/Ctool/employee/employeeList');
		res.success(function(data, status) {
			
			$scope.dashboardData = data.object;
		});
	}

});


app.controller("editVariableController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.vars = sharedProperties.getValue("ratingVariableData");
	
	if($scope.vars==undefined)
		{
		$window.location.href = '#/slabVariable';
		}
	
	$scope.addVariableRating=function()
	{
		var data=$scope.vars;
		
		$scope.pageloader=true;
		 $http({
		        method : "POST",
		        url : "/Ctool/slab/save/variable",
		        data:data
		    }).then(function mySuccess(response) {
	    	$scope.pageloader=false;
		        $scope.slabStatus = response.data;
		        if( $scope.slabStatus.status)
		        	{
		        	
		        	Swal.fire(
		        			  'Success!',
		        			  'Rating  Updated Successfully',
		        			  'success'
		        			  
		        			)
		        		      $window.location.href = '#/slabVariable';
		 		   
		        	
		        	}
		        else
		        	{
		        	/*swal("Failed", "Something went wrong", "error");
		        	*/
		        	Swal.fire(
		        			  'Failed!',
		        			  'Something went wrong',
		        			  'error'
		        			)
		        	}
		        
		       
		    }, function myError(response) {
		        $scope.myWelcome = response.statusText;
		    });
			
	}
	
});
app.controller("addVariablenonrooftopController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.vars={
			"ratMin":"1",
			"ratMax":"1"
	}
	
	
	
	$scope.init=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
		var res = $http.post('/Ctool/variable/ratingEmployeeNonRoofTop');
		res.success(function(data, status) {
			Swal.close();
			 $scope.employeeVariblelistnonRoofTop = data.object;
		});
	
	
	}
	
	
	
	
	$scope.addVariableRating=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		
		var data=$scope.vars;
		
	
		 $http({
		        method : "POST",
		        url : "/Ctool/variable/saveEmployeeVariableNonRoofTop",
		        data:data
		    }).then(function mySuccess(response) {
		    	Swal.close();
		        $scope.slabStatus = response.data;
		        $scope.employeeVariblelistnonRoofTop=response.data.object;
		        $scope.vars=null;
		        if( $scope.slabStatus.status)
		        	{
		        	Swal.fire(
		        			  'Success',
		        			  'Rating  created Successfully',
		        			  'success'
		        			)
		        	
		        	}
		        else
		        	{
		        	Swal.fire("Failed", "Something went wrong", "error");
		        	}
		        
		    }, function myError(response) {
		        $scope.myWelcome = response.statusText;
		    });
			
	}
	
	
	
	$scope.edit=function(data)
	{
		$scope.vars=data
	}

	
});
app.controller("viewVariablenonrooftopController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.slabVariableInit=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
		var res = $http.post('/Ctool/variable/ratingEmployeeNonRoofTop');
		res.success(function(data, status) {
			Swal.close();
			$scope.ratingvariableList = data.object;
		});
	}
	
	$scope.editslabVariable=function(editdata)
	{
		$window.location.href = '#/editVariable';
		sharedProperties.setValue("ratingVariableData", editdata);
	}
	
});

app.controller("viewSlabController", function($scope, $http, $timeout,sharedProperties,$window) {


$scope.viewslabInit=function()
{
	$scope.pageloader=true;
	 $http({
	        method : "POST",
	        url : "/Ctool/slab/list"
	    }).then(function mySuccess(response) {
	    	$scope.pageloader=false;
	        $scope.slabList = response.data.object;
	      
	    }, function myError(response) {
	        $scope.myWelcome = response.statusText;
	    });
		
}



$scope.editConfig=function(editdata)
{
	$window.location.href = '#/addSlab';
	sharedProperties.setValue("slabData", editdata);
}


$scope.deleteSlab=function(slab)
{
	
	Swal.fire({
		  title: 'Are you sure?',
		  text: "You won't be able to revert this!",
		  type: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Yes, delete it!'
		}).then((result) => {
		  if (result.value) {
		    Swal.fire(
		      'Deleted!',
		      'Your file has been deleted.',
		      'success'
		    )
		  }
		  else
			  {
			  Swal.fire(
				      'Deleted!',
				      'Your data is safe.',
				      'success'
				    )
			  }
		})
		
	
	swal({
		  title: "Are you sure?",
		  text: "Once deleted, you will not be able to recover this  data!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  
			  
				var data=slab;
				
				$scope.pageloader=true;
				 $http({
				        method : "POST",
				        url : "/Ctool/slab/delete",
				        data:data
				    }).then(function mySuccess(response) {
			    	$scope.pageloader=false;
				        $scope.slabStatus = response.data;
				        if( $scope.slabStatus.status)
				        	{
				        	 swal("Poof! Your data has been deleted!", {
							      icon: "success",
							    });
				        	 $scope.slabList = response.data.object;
						      
				        	}
				        else
				        	{
				        	 swal("Something went wrong !.", {
							      icon: "error",
							    });	}
				        
				    }, function myError(response) {
				        $scope.myWelcome = response.statusText;
				    });   
		  } else {
			  
			  swal("Your data is safe!", {
			      icon: "success",
			    });  
		  }
		});
	
	
	
	
	
	
	

		
}

});


app.controller("addSlabController", function($scope, $http, $timeout,sharedProperties,$window) {

$scope.slab={
		"designation":"Senior Vice President"
}

$scope.slabdata = sharedProperties.getValue("slabData");
if ($scope.slab == undefined) {
	$window.location.href = '#/viewSlab';
}
else
{
$scope.slab=$scope.slabdata;	
}

$scope.addSlab=function()
{
	var data=$scope.slab;
	
	$scope.pageloader=true;
	 $http({
	        method : "POST",
	        url : "/Ctool/slab/save",
	        data:data
	    }).then(function mySuccess(response) {
    	$scope.pageloader=false;
	        $scope.slabStatus = response.data;
	        if( $scope.slabStatus.status)
	        	{
	        	swal("Success", "File Successfully created", "success");
	        	}
	        else
	        	{
	        	swal("Failed", "Something went wrong", "error");
	        	}
	        
	    }, function myError(response) {
	        $scope.myWelcome = response.statusText;
	    });
		
}

});




app.controller("ViewGeneratedPDfController", function($scope, $http, $timeout,sharedProperties,$window) {
	$scope.getDataOnLoad = function() {
		
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		var res = $http.post('/Ctool/employee/pdfDocumentsList');
		res.success(function(data, status) {
			Swal.close();
			$scope.pdfList = data;
			console.log($scope.pdfList);
		});
	}
	
	
	
	$scope.pdftoword=function(filename)
	{
		var data1={
				"filename":filename
		}
		
		 $http({
			    method : "POST",
			      url : "/Ctool/employee/convertpdftoword",
			      params:data1
			  }).then(function mySuccess(response) {
			    $scope.myWelcome = response.data;
			  }, function myError(response) {
			    $scope.myWelcome = response.statusText;
			  });
		 
	
	}
});

app.controller("EmployeeListController", function($scope, $http, $timeout,sharedProperties,$window,ServicePDF, ServiceWord) {
	
	$scope.gridOptions = {
			showGridFooter : true,
			multiSelect : false,
			enableFiltering : true,
			enableGridMenu : true,
			enableSelectAll : true,
			exporterMenuPdf : false, // ADD THIS
			exporterCsvFilename : 'employeeList.csv',
			exporterCsvLinkElement : angular.element(document
					.querySelectorAll(".custom-csv-link-location")),
					
			columnDefs : [
					{
						name : 'Sr #',
						field : '<span>{{rowRenderIndex+1}}</span>',
						width : '5%',
						cellTemplate : '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>'
					},
					{
						name : 'Name',
						field : 'empName',
//						width : '15%'
					},
					{
						name : 'Employee Code',
						field : 'empCode',
//						width : '10%'
					},
					{
						name : 'Department',
						field : 'department',
//						width : '15%'
					},
					{
						name : 'Designation',
						field : 'designation',
//						width : '15%'
					}
//					,
//					{
//						name : 'Edit',
//						cellTemplate : '<div style ="text-align : center;"> <button  class=" btn-primary "  ng-click="grid.appScope.modifyEmployee(row.entity)" ><span class="glyphicon glyphicon-pencil" style="margin: 0px;"></span> </button></div>',
//						width : '5%'
//					},
//					{
//						name : 'Delete',
//						cellTemplate : '<div style ="text-align : center;"> <button  class=" btn-danger"  ng-click="grid.appScope.deleteEmployee(row.entity.id)"><span class="fa fa-trash" style="margin: 0px;"></span> </button></div>',
//						width : '5%'
//					}
					]
		};

	$scope.getDataOnLoad = function() {
		
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
		var res = $http.post('/Ctool/employee/employeePromtionListgenerated');
		res.success(function(data, status) {
			$scope.gridOptions.data = data;
			$scope.employeePromtionListgenerated=data;
			
		});
		
		var res1 = $http.post('/Ctool/employee/employeePromtionListnotgenerated');
		res1.success(function(data, status) {
			Swal.close();
			$scope.gridOptions.data = data;
			$scope.employeePromtionListnotgenerated=data;
			
		});
	}
	
	$scope.generatePDF = function() {
//		var res = $http.post('/Ctool/employee/employeeGeneratePDF');
//		res.success(function(data, status) {
//			$scope.status = data.status;
//			if($scope.status === true)
//				{
//				swal("Success", "File Successfully created", "success");
//				}
//			else{
//				swal("Failed", "Something Went Wrong", "error");	
//			}
//		});
//	}
//		$http.post("/Ctool/documentDownload", {
//					transformRequest : angular.identity,
//					headers : {
//						'Content-Type' : undefined
//					}
//				})
//				.success(
//						function(data, status, headers) {
//							if (status == 200) {
//								headers = headers();
//								if (headers['content-type'] == "application/pdf") {
//									var filename = headers['content-disposition'];
//									var contentType = headers['content-type'];
//									var linkElement = document
//											.createElement('a');
//									try {
//										var blob = new Blob(
//												[ data ],
//												{
//													type : contentType
//												});
//										var url = window.URL
//												.createObjectURL(blob);
//
//										linkElement
//												.setAttribute(
//														'href',
//														url);
//										linkElement
//												.setAttribute(
//														"download",
//														filename);
//										var clickEvent = new MouseEvent(
//												"click",
//												{
//													"view" : window,
//													"bubbles" : true,
//													"cancelable" : false
//												});
//										linkElement
//												.dispatchEvent(clickEvent);
//									} catch (ex) {
//
//									}
//								}
//							}
//						});
		var fileName = "IncrementLetter.pdf";
        var a = document.createElement("a");
        document.body.appendChild(a);
        ServicePDF.downloadPdf().then(function (result) {
            var file = new Blob([result.data], {type: 'application/pdf'});
            var fileURL = window.URL.createObjectURL(file);
            a.href = fileURL;
            a.download = fileName;
            a.click();
            
            $scope.getDataOnLoad();
        });
	}
	

	$scope.generateWord = function(){
		
		var fileName = "IncrementLetter.docx";
		 var a = document.createElement("a");
	        document.body.appendChild(a);
	        ServiceWord.downloadWord().then(function (result) {
	        	 var file = new Blob([result.data],{type:' application/vnd.openxmlformats-officedocument.wordprocessingml.document'})
	    		 var fileURL = window.URL.createObjectURL(file);
	    		
	    		a.href=fileURL;
	    		a.download=fileName;
	    		a.click();
	            $scope.getDataOnLoad();
	        });
	        }
	
});
app.controller("EmployeeBasicDetailsController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.uploadbtn = false;
	$scope.uploadspinner = false;
	$scope.uploadEmployeeBasicDetailsFiles = function() {
		
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
	
	
		$scope.uploadbtn = true;
		$scope.uploadspinner = true;
		var formdata = new FormData();
		formdata.append("file1", image1);
		$http.post("/Ctool/employee/uploadEmployeeBasicDetailsFiles", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.clientadd = response.data.status;
			if ($scope.clientadd) {
				$scope.pageloader=false;
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
				Swal.fire('Any fool can use a computer')
				swal("Success", "Data Updated Successfully", "success");
				$scope.message = response.data.message;
			} else {
				document.getElementById("main_body").className = "";
				swal("Failed", "Something Went Wrong", "error");	
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
			}
		}, function myError(response) {
			$scope.pageloader=false;
			document.getElementById("main_body").className = "";
			swal("Failed", "Something Went Wrong", "error");
			$scope.listerror = response.statusText;
			
		});

	}

	
});


app.controller("EmployeeFinalCalculationController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.uploadbtn = false;
	$scope.uploadspinner = false;

	$scope.uploadFiles = function() {
		$scope.pageloader=true;
		document.getElementById("main_body").className = "loading";
		$scope.uploadbtn = true;
		$scope.uploadspinner = true;
		var formdata = new FormData();
		formdata.append("file1", image1);
		$http.post("/Ctool/employee/finalCalculation", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.clientadd = response.data.status;
			if ($scope.clientadd) {
				$scope.pageloader=false;
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
				document.getElementById("main_body").className = "";
				swal("Success", "Data Updated Successfully", "success");
				$scope.message = response.data.message;
			} else {
				document.getElementById("main_body").className = "";
				swal("Failed", "Something Went Wrong", "error");	
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
			}
		}, function myError(response) {
			$scope.pageloader=false;
			document.getElementById("main_body").className = "";
			swal("Failed", "Something Went Wrong", "error");
			$scope.listerror = response.statusText;
			
		});

	}

	
});


app.controller("configController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	
	
	$scope.uploadFiles=function()
	{
		$scope.pageloader=true;
		document.getElementById("main_body").className = "loading";
		$scope.uploadbtn = true;
		$scope.uploadspinner = true;
		var formdata = new FormData();
		formdata.append("file1", image1);
		$http.post("/Ctool/config/bulk", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.clientadd = response.data.status;
			if ($scope.clientadd) {
				$scope.pageloader=false;
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
				document.getElementById("main_body").className = "";
				swal("Success", "Data Updated Successfully", "success");
				$scope.message = response.data.message;
			} else {
				document.getElementById("main_body").className = "";
				swal("Failed", "Something Went Wrong", "error");	
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
			}
		}, function myError(response) {
			$scope.pageloader=false;
			document.getElementById("main_body").className = "";
			swal("Failed", "Something Went Wrong", "error");
			$scope.listerror = response.statusText;
			
		});
	
	}
	
	
	
});

app.controller("configurationController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	$scope.editconfigdata = sharedProperties.getValue("editconfigdata");
	if ($scope.editconfigdata == undefined) {
		$window.location.href = '#/viewconfiguration';
	}
	else
	{
	$scope.config=$scope.editconfigdata;	
	}
	
	
	$scope.configInit=function()
	{/*
		 
		$scope.pageloader=true;
		 $http({
		        method : "POST",
		        url : "http://192.168.10.248:8080/PMS/get-all-departments"
		    }).then(function mySuccess(response) {
		    	$scope.pageloader=false;
		        $scope.departmentList = response.data;
		        $(function() {
				$scope.table = $('#example1')
						.DataTable(
								{
									'autoWidth' : false,
									"scrollY" : "380px",
									"scrollCollapse" : true,
									"stateSave" : true,
									"paging" : false
								})
			})
		    }, function myError(response) {
		        $scope.myWelcome = response.statusText;
		    });
			
	*/}
	
});






app.controller("viewconfigurationClientController", function($scope, $http, $timeout,sharedProperties,$window) {
	
	
	$scope.viewconfigInit=function()
	{
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		 
		
		 $http({
		        method : "POST",
		        url : "/Ctool/config/list"
		    }).then(function mySuccess(response) {
		    	 Swal.close();
		        $scope.configurationList = response.data.object;
		        /*$(function() {
				$scope.table = $('#example1')
						.DataTable(
								{
									'autoWidth' : false,
									"scrollY" : "380px",
									"scrollCollapse" : true,
									"stateSave" : true,
									"paging" : false
								})
			})*/
		    }, function myError(response) {
		        $scope.myWelcome = response.statusText;
		    });
			
	}
	
	
	
	$scope.editConfig=function(editconfigdata)
	{
		$window.location.href = '#/configuration';
		sharedProperties.setValue("editconfigdata", editconfigdata);
	}
});


// Home controller

app.controller('NavigationController', function($scope, $http) {

	$http.get('/Ctool/get-menu-items').success(function(data) {
		$scope.items = data;
	});

});

app.controller("employeeController", function($scope, $http, $timeout,$window,sharedProperties,$filter) {
	
	
	
	jQuery(document).ready(function($) {
		  $("a.word-export").click(function(event) {
		    $("#page-content").wordExport();
		  });
		});
	
	
	$scope.basic=30;
	
	$scope.employeeDetails = sharedProperties.getValue("employeeDetails");
	
	$scope.parseInt = parseInt;
	$scope.employee={
			"newPromotion":"No"
	}
	
	if ($scope.employeeDetails == undefined) {
		$window.location.href = '#/viewemployee';
	}
	else
	{
			
	$scope.employee = $scope.employeeDetails;

	if($scope.employee.department=="Solar Rooftop")
		{
		
		$scope.variable1="40"
			$scope.variable2="60"
		
		}
	else 
		{
		
		$scope.variable1="33"
			$scope.variable2="67"
		}
	$scope.spvsId = $scope.employee.spvsId;
	$scope.incrementLetterDetailsId=$scope.employee.incrementLetterDetailsId;
	$scope.variableTypeId=$scope.employee.variableTypeId;
	
	$scope.employee.newCTCMonths = ((parseInt($scope.employee.newCTCYear))/12);
	$scope.employee.newCTCMonth=Math.round($scope.employee.newCTCMonths);
	
	$scope.employee.newCTCYears = (parseInt($scope.employee.newCTCYear));
	$scope.employee.newCTCYear=Math.round($scope.employee.newCTCYears);
	
	var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
	var firstDate = new Date($scope.employee.dateOfJoining);
	var secondDate = new Date();
	$scope.employee.totalTenure = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime())/(oneDay)));
	
	
	var res = $http.post('/Ctool/employee/variableTypeList');
	res.success(function(data, status) {
		Swal.close();
		$scope.testVariableType = data.object;
		for(var i=0;i<$scope.testVariableType.length;i++)
		{
		if($scope.testVariableType[i].id == $scope.variableTypeId)
			{
			$scope.variableTypeId=$scope.testVariableType[i];
		
			break;
			}
		}
	});
	
	
	var res = $http.post('/Ctool/spvs/list');
	res.success(function(data, status) {
		Swal.close();
		$scope.spvslist = data.object;
		for(var i=0;i<$scope.spvslist.length;i++)
		{
		if($scope.spvslist[i].id == $scope.spvsId)
			{
			$scope.spvsId=$scope.spvslist[i];
		
			break;
			}
		}
	});
	
	var res2 = $http.post('/Ctool/increment/letterDetails/list');
	res2.success(function(data, status) {
		Swal.close();
		$scope.incrementLetterDetails = data.object;
		for(var i=0;i<$scope.incrementLetterDetails.length;i++)
		{
		if($scope.incrementLetterDetails[i].id == $scope.incrementLetterDetailsId)
			{
			$scope.incrementLetterDetailsId=$scope.incrementLetterDetails[i];
		
			break;
			}
		}

	});
	
	
	
	
	}
	
//	$scope.getDataOnLoad = function() {
//		var res = $http.post('/Ctool/slab/rating/variable');
//		res.success(function(data, status) {
//			$scope.ratingvariableList = data.object;
//		});
//	}
	$scope.getDataOnLoad = function() {
		
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		var res = $http.post('/Ctool/employee/employeeList');
		res.success(function(data, status) {
			Swal.close();
			$scope.pankaj = data.object;
		});
		
		
	}
	
	
	$scope.nextEmployee=function()
	{
		
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
		
		
		$scope.basic=30;
		$scope.employee=angular.fromJson($scope.details);
		$scope.spvsId = $scope.employee.spvsId;
		$scope.incrementLetterDetailsId=$scope.employee.incrementLetterDetailsId;
		$scope.variableTypeId=$scope.employee.variableTypeId;

		var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
		var firstDate = new Date($scope.employee.dateOfJoining);
		var secondDate = new Date();
		$scope.employee.totalTenure = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime())/(oneDay)));
		
		var res = $http.post('/Ctool/employee/variableTypeList');
		res.success(function(data, status) {
			Swal.close();
			$scope.testVariableType = data.object;
			for(var i=0;i<$scope.testVariableType.length;i++)
			{
			if($scope.testVariableType[i].id == $scope.variableTypeId)
				{
				$scope.variableTypeId=$scope.testVariableType[i];
			
				break;
				}
			}
		});
		
		
		var res1 = $http.post('/Ctool/increment/letterDetails/list');
		res1.success(function(data, status) {
			Swal.close();
			$scope.incrementLetterDetails = data.object;
			for(var i=0;i<$scope.incrementLetterDetails.length;i++)
			{
			if($scope.incrementLetterDetails[i].id == $scope.incrementLetterDetailsId)
				{
				$scope.incrementLetterDetailsId=$scope.incrementLetterDetails[i];
			
				break;
				}
			}

		});
		
		var res2 = $http.post('/Ctool/spvs/list');
		res2.success(function(data, status) {
			Swal.close();
			$scope.spvslist = data.object;
			for(var i=0;i<$scope.spvslist.length;i++)
			{
			if($scope.spvslist[i].id == $scope.spvsId)
				{
				$scope.spvsId=$scope.spvslist[i];
				console.log($scope.spvsId)
				break;
				}
			}
		});
		
	
		

	}
	
	
	
//	$scope.calculateBasicDetails = function(){
//		var input ={
//				"fixedSalaryPerMonth":$scope.employee.fixedSalaryPerMonth,
//				"variable":$scope.employee.variable
//		};
//		var res = $http.post('/Ctool/employee/calculateBasicDetails',input);
//		res.success(function(data, status) {
//			$scope.slabList = data.object;
//		});
//	}
	
	
	//changeeee
	
	$scope.calculateWithReqApril = function()
	{
		if($scope.employee.incrementWRTRating === null && $scope.employee.rationalizationHRFactor === null && $scope.employee.promotion === null && $scope.employee.retention === null )
			{
			Swal.fire("Failed", "Please fill the required input", "error");
			}
		else{
			
			$scope.employee.incrementWEFApril = parseInt($scope.employee.incrementWRTRating) + parseInt($scope.employee.rationalizationHRFactor) + parseInt($scope.employee.promotion) + parseInt($scope.employee.retention) ;
		    $scope.employee.incrementAmounts = (parseInt($scope.employee.fixedSalaryPerYear) * parseInt($scope.employee.incrementWEFApril))/100;
		    $scope.employee.incrementAmount=Math.round($scope.employee.incrementAmounts);
		    $scope.employee.newFixedSalaryPerYears = (parseInt($scope.employee.fixedSalaryPerYear))  + $scope.employee.incrementAmount;
		    $scope.employee.newFixedSalaryPerYear= Math.round( $scope.employee.newFixedSalaryPerYears);
		    
	//	    $scope.employee.variableAmountCurrentYear = ($scope.employee.newFixedSalaryPerYear * $scope.employee.newVariable)/100;
           $scope.employee.newFixedSalaryPerMonth = Math.round((parseInt($scope.employee.newFixedSalaryPerYear))/12);
		    
		   // $scope.employee.newFixedSalaryPerMonth=Math.round( $scope.employee.newFixedSalaryPerMonths)
		    
		  //  $scope.employee.newVariable = $scope.employee.variable;
		    $scope.employee.newVariablePerYear = (((parseInt($scope.employee.newFixedSalaryPerYear))* (parseInt($scope.employee.newVariable))/100));
		    $scope.employee.basicSalary = Math.round(($scope.employee.newFixedSalaryPerMonth * $scope.basic)/100);
			$scope.employee.hr =Math.round(($scope.employee.basicSalary * 50)/100);
		    $scope.employee.newCTCMonths = 0;
		    $scope.employee.newCTCYears=(parseInt($scope.employee.newFixedSalaryPerYear) +parseInt($scope.employee.newVariablePerYear))
		    $scope.employee.newCTCYear=Math.round($scope.employee.newCTCYears);
		    $scope.employee.newCTCMonth=Math.round($scope.employee.newCTCYear/12);
		    $scope.employee.variableAmountCurrentYear=parseInt(($scope.employee.newCTCYears * 10)/100);
		    $scope.employee.variablePay=$scope.employee.variableAmountCurrentYear;
		    
//		    $scope.employee.newCTCYear = (parseInt($scope.employee.newFixedSalaryPerYear)) +  (parseInt($scope.employee.newVariablePerYear));
		    $scope.employee.netIncreaseYearly = (parseInt($scope.employee.newCTCYear)) - (parseInt($scope.employee.currentCTCPerYear));
		   // $scope.employee.specialAllowance="0";
		    $scope.employee.supplementaryAllowance="5000";
		    $scope.employee.childrenEducationAllowance="0";
		 
		    $scope.employee.attire="0";
		    $scope.employee.newspaper="0";
		    $scope.employee.lta="0";
		    $scope.employee.residentTelephone="0";
		    $scope.employee.gratuity= Math.round(($scope.employee.basicSalary/26) * (1.25));
		    $scope.employee.pf= Math.round((parseInt($scope.employee.basicSalary)*12)/100);
		 //   $scope.fixedCtcABCD=parseInt($scope.employee.basicSalary) + parseInt($scope.employee.hr)+ parseInt($scope.employee.specialAllowance)+ parseInt($scope.employee.supplementaryAllowance)+ parseInt($scope.employee.childrenEducationAllowance)+ parseInt($scope.employee.pf) + parseInt($scope.employee.residentTelephone)+ parseInt($scope.employee.attire)+ parseInt($scope.employee.newspaper)+ parseInt($scope.employee.lta)+ parseInt($scope.employee.gratuity);
		  

		    if($scope.employee.carLease=='Yes')
		    	{
		    	$scope.employee.specialAllowance=Math.round($scope.employee.newFixedSalaryPerMonth -(parseInt($scope.employee.basicSalary) + parseInt($scope.employee.hr)+ parseInt($scope.employee.supplementaryAllowance)+ parseInt($scope.employee.childrenEducationAllowance)+ parseInt($scope.employee.pf)+ parseInt($scope.employee.residentTelephone)+ parseInt($scope.employee.attire)+ parseInt($scope.employee.newspaper)+ parseInt($scope.employee.lta)+ parseInt($scope.employee.gratuity))- parseInt($scope.employee.carLeaseAmount));	
		    	}
		    else
		    	{
		    	$scope.employee.specialAllowance=Math.round($scope.employee.newFixedSalaryPerMonth -(parseInt($scope.employee.basicSalary) + parseInt($scope.employee.hr)+ parseInt($scope.employee.supplementaryAllowance)+ parseInt($scope.employee.childrenEducationAllowance)+ parseInt($scope.employee.pf)+ parseInt($scope.employee.residentTelephone)+ parseInt($scope.employee.attire)+ parseInt($scope.employee.newspaper)+ parseInt($scope.employee.lta)+ parseInt($scope.employee.gratuity)));
			    	
		    	}
		    
		    
			Swal.fire(
					  'Success',
					  'Calculated Successfully',
					  'success'
					)
			}
	}
	
	$scope.calculateBasicDetails = function()
	{
		
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
			
	if($scope.employee.department=="Solar Rooftop")
		{			var res1 = $http.post('/Ctool/variable/listRoofTop40');
		res1.success(function(data, status) {
			 $scope.ratingvariableListnonRooftop = data.object;
			 
			 var res = $http.post('/Ctool/variable/ratingEmployeeRoofTop');
				res.success(function(data, status) {
					Swal.close();
					 $scope.employeeVariblelistNonRoofTop = data.object;
					 for(var i=0;i<$scope.employeeVariblelistNonRoofTop.length;i++)
						{
						if($scope.employeeVariblelistNonRoofTop[i].ratMin <= $scope.employee.finalYearRating  && $scope.employee.finalYearRating <= $scope.employeeVariblelistNonRoofTop[i].ratMax)
							{
							$scope.employeeRatingVariable = $scope.employeeVariblelistNonRoofTop[i].variable;
							$scope.employee.newVariable=$scope.employee.variable;
						break;
							}
						}
					    $scope.employee.fixedSalaryPerYear = $scope.employee.fixedSalaryPerMonth * 12;
						$scope.employee.variableAmountCurrentYear = ($scope.employee.fixedSalaryPerYear * $scope.employee.variable)/100;
						$scope.employee.currentCTCPerYear = $scope.employee.fixedSalaryPerYear + $scope.employee.variableAmountCurrentYear ;
						$scope.employee.currentCTCPerMonths = ($scope.employee.currentCTCPerYear)/12;
						$scope.employee.currentCTCPerMonth=Math.round($scope.employee.currentCTCPerMonths);
						$scope.numberOfMonths = $scope.monthDiff(new Date($scope.employee.dateOfJoining),new Date());
						
						var joiningDate = new Date($scope.employee.dateOfJoining);
						var todayDate = new Date();
						$scope.numberOfdaysofjoining = Math.round(Math.abs((joiningDate.getTime() - todayDate.getTime())/(oneDay)));
						
						 var uppercaseFilter = $filter('dayTomonthwithoutSymbol');

						    // HELLO
						  
						$scope.joiningMonth=new Date($scope.employee.dateOfJoining).getMonth()+1;
						$scope.joiningYear=new Date($scope.employee.dateOfJoining).getFullYear();
						$scope.joiningDate=new Date($scope.employee.dateOfJoining).getDate();
						$scope.currentYear=new Date().getFullYear();
						$scope.employee.monthCurrentDateDOJ = Math.round((parseInt($scope.numberOfMonths)));
						
						$scope.employee.variable33=(parseInt(($scope.employee.variableAmountCurrentYear*33))/100);
						$scope.employee.variable67=(parseInt(($scope.employee.variableAmountCurrentYear*67))/100);
						
						$scope.companyVariable=$scope.ratingvariableListnonRooftop[0].variable;
						console.log($scope.ratingvariableListnonRooftop[0].variable +" "+ $scope.employeeRatingVariable)
						$scope.newvariable33=(parseInt((($scope.employee.variable33 * $scope.ratingvariableListnonRooftop[0].variable)/100)));
						$scope.newvariable67=(parseInt((($scope.employee.variable67 * $scope.employeeRatingVariable)/100)));
						
						if($scope.employee.totalmnth==12)
							{
							$scope.employee.disbursedVariable=Math.round(($scope.newvariable33 + $scope.newvariable67));
							
							}
						else
							{
							$scope.employee.disbursedVariable=Math.round(($scope.newvariable33 + $scope.newvariable67) /* * ($scope.employee.totalmnth)*/);
							$scope.employee.disbursedVariable=Math.round((($scope.employee.disbursedVariable)/12)*$scope.employee.totalmnth);
							
							}
						
						
				/*		$scope.employee.disbursedVariable = Math.trunc(($scope.employee.variableAmountCurrentYear/12)* $scope.numberOfMonths);
						
						$scope.employee.variable33 =  Math.round(($scope.employee.disbursedVariable * $scope.slabValue))/100;
						$scope.employee.variable67 =  Math.round(($scope.employee.disbursedVariable * $scope.remainingSlabValue))/100;*/
						$scope.employee.disbursedVariableZ = Math.round((parseInt($scope.employee.finalYearRating))) + Math.round((parseInt($scope.employee.disbursedVariable)));
						
						var res = $http.post('/Ctool/increment/list');
						res.success(function(data, status) {
							$scope.incrementvariableList = data.object;
							
							for(var i=0;i<$scope.incrementvariableList.length;i++)
							{
							if($scope.incrementvariableList[i].ratMin <= $scope.employee.finalYearRating  && $scope.employee.finalYearRating <= $scope.incrementvariableList[i].ratMax)
								{
								$scope.employee.incrementWRTRating = $scope.incrementvariableList[i].variable;
								break;
								}
							}
						});
					 
					});
		});
		
		
		}
	else 
		{			
		var res1 = $http.post('/Ctool/variable/listnonRoofTop');
		res1.success(function(data, status) {
			 $scope.ratingvariableListnonRooftop = data.object;
			 
			 var res = $http.post('/Ctool/variable/ratingEmployeeNonRoofTop');
				res.success(function(data, status) {
					Swal.close();
					 $scope.employeeVariblelistNonRoofTop = data.object;
					 for(var i=0;i<$scope.employeeVariblelistNonRoofTop.length;i++)
						{
						if($scope.employeeVariblelistNonRoofTop[i].ratMin <= $scope.employee.finalYearRating  && $scope.employee.finalYearRating <= $scope.employeeVariblelistNonRoofTop[i].ratMax)
							{
							$scope.employeeRatingVariable = $scope.employeeVariblelistNonRoofTop[i].variable;
							$scope.employee.newVariable=$scope.employee.variable;
						break;
							}
						}
					    $scope.employee.fixedSalaryPerYear = $scope.employee.fixedSalaryPerMonth * 12;
						$scope.employee.variableAmountCurrentYear = ($scope.employee.fixedSalaryPerYear * $scope.employee.variable)/100;
						$scope.employee.currentCTCPerYear = $scope.employee.fixedSalaryPerYear + $scope.employee.variableAmountCurrentYear ;
						$scope.employee.currentCTCPerMonths = ($scope.employee.currentCTCPerYear)/12;
						$scope.employee.currentCTCPerMonth=Math.round($scope.employee.currentCTCPerMonths);
						$scope.numberOfMonths = $scope.monthDiff(new Date($scope.employee.dateOfJoining),new Date());
						
						var joiningDate = new Date($scope.employee.dateOfJoining);
						var todayDate = new Date();
						$scope.numberOfdaysofjoining = Math.round(Math.abs((joiningDate.getTime() - todayDate.getTime())/(oneDay)));
						
						 var uppercaseFilter = $filter('dayTomonthwithoutSymbol');

						 
						  
						$scope.joiningMonth=new Date($scope.employee.dateOfJoining).getMonth()+1;
						$scope.joiningYear=new Date($scope.employee.dateOfJoining).getFullYear();
						$scope.joiningDate=new Date($scope.employee.dateOfJoining).getDate();
						$scope.currentYear=new Date().getFullYear();
						
						
					
						$scope.employee.monthCurrentDateDOJ = Math.round((parseInt($scope.numberOfMonths)));
						
					
//						$scope.employee.disbursedVariable = Math.trunc(($scope.employee.variable/12)* $scope.numberOfMonths);
						
						$scope.employee.variable33=(parseInt(($scope.employee.variableAmountCurrentYear*33))/100);
						$scope.employee.variable67=(parseInt(($scope.employee.variableAmountCurrentYear*67))/100);
						
						$scope.companyVariable=$scope.ratingvariableListnonRooftop[0].variable;
						console.log($scope.ratingvariableListnonRooftop[0].variable +" "+ $scope.employeeRatingVariable)
						$scope.newvariable33=(parseInt((($scope.employee.variable33 * $scope.ratingvariableListnonRooftop[0].variable)/100)));
						$scope.newvariable67=(parseInt((($scope.employee.variable67 * $scope.employeeRatingVariable)/100)));
						
						if($scope.employee.totalmnth==12)
						{
						$scope.employee.disbursedVariable=Math.round(($scope.newvariable33 + $scope.newvariable67));
						
						}
					else
						{
						$scope.employee.disbursedVariable=Math.round(($scope.newvariable33 + $scope.newvariable67) /* * ($scope.employee.totalmnth)*/);
						$scope.employee.disbursedVariable=Math.round((($scope.employee.disbursedVariable)/12)*$scope.employee.totalmnth);
						
						}
						
						
				/*		$scope.employee.disbursedVariable = Math.trunc(($scope.employee.variableAmountCurrentYear/12)* $scope.numberOfMonths);
						
						$scope.employee.variable33 =  Math.round(($scope.employee.disbursedVariable * $scope.slabValue))/100;
						$scope.employee.variable67 =  Math.round(($scope.employee.disbursedVariable * $scope.remainingSlabValue))/100;*/
						$scope.employee.disbursedVariableZ = Math.round((parseInt($scope.employee.finalYearRating))) + Math.round((parseInt($scope.employee.disbursedVariable)));
						
						var res = $http.post('/Ctool/increment/list');
						res.success(function(data, status) {
							$scope.incrementvariableList = data.object;
							
							for(var i=0;i<$scope.incrementvariableList.length;i++)
							{
							if($scope.incrementvariableList[i].ratMin <= $scope.employee.finalYearRating  && $scope.employee.finalYearRating <= $scope.incrementvariableList[i].ratMax)
								{
								$scope.employee.incrementWRTRating = $scope.incrementvariableList[i].variable;
								break;
								}
							}
						});
					 
					});
		});
		
		}
			
			
			
			
			

		
		
		
		
		
	}
	
	
//	
//	$scope.calculateCtcBrekup=function()
//	{
//		
//	}
//	
	$scope.monthDiff = function (d1, d2) {
	    var months;
	    months = (d2.getFullYear() - d1.getFullYear()) * 12;
	    months -= d1.getMonth() + 1;
	    months += d2.getMonth();
	    return months <= 0 ? 0 : months;
	}
   
	$scope.save = function() {
		
		Swal.fire({
			  title: 'Are you sure?',
			  text: "Once Updated, you will not be able to recover this.",
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes, Update it!'
			}).then((result) => {
			  if (result.value) {
				  
				  Swal.fire({
					  imageUrl: '/Ctool/resources/images/preview-loader.gif',
					  imageHeight: 100,
					  showConfirmButton: false,
					  allowEscapeKey:false,
					  allowOutsideClick:false
					})
				

					$scope.employee.spvsId = $scope.spvsId.id;
					$scope.employee.incrementLetterDetailsId= $scope.incrementLetterDetailsId.id;
					$scope.employee.variableTypeId= $scope.variableTypeId.id;
					if($scope.employee.variableTypeId ==3)
						{
						$scope.employee.variablePay=0.0;
						}
					else
						{
						$scope.employee.variablePay=$scope.employee.variableAmountCurrentYear
						}
					var data1 = $scope.employee;
					$http({
						method : "POST",
						url : "/Ctool/employee/update",
						data : data1,
					}).then(function mySuccess(response) {
						Swal.close();
						$scope.admin = null;
						$scope.employeeStatus = response.data.status;
						if($scope.employeeStatus)
							{
							$scope.employee=null;
							$scope.loader=false;
							 Swal.fire(
								      'Success!',
								      'Data Updated Successfully',
								      'Success'
								    )
								    
								    
								    
								    
								    
								    
								    
							/*swal("Success! Data Updated Successfully", {
							      icon: "success",
							    });*/
							$timeout(function() {
								$window.location.href = '#/viewemployee';
							}, 2000);
							}
						else
							{
							$scope.loader=false;
							$scope.employee=null;
							Swal.fire("Failed", "Someting Went Wrong", "error");
							$timeout(function() {
								$window.location.href = '#/viewemployee';
							}, 2000);
							}
					}, function myError(response) {
						$scope.myWelcome = response.statusText.status;
						Swal.fire("Failed", "Someting Went Wrong", "error");
						$timeout(function() {
							$window.location.href = '#/viewemployee';
						}, 4000);
					});
				
				  
				  
			   
			  }
			  
			  else
				  {
				  Swal.fire("Your imaginary file is safe!");
				  }
			})
		
		
		
		
/*		
		
			swal({
				  title: "Are you sure?",
				  text: "Once Updated, you will not be able to recover this.",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
				.then((willDelete) => {
				  if (willDelete) {
						$scope.loader=true;									
						var data1 = $scope.employee;
						$http({
							method : "POST",
							url : "/Ctool/employee/update",
							data : data1,
						}).then(function mySuccess(response) {
							$scope.admin = null;
							$scope.employeeStatus = response.data.status;
							if($scope.employeeStatus)
								{
								$scope.employee=null;
								$scope.loader=false;
								swal("Success! Data Updated Successfully", {
								      icon: "success",
								    });
								$timeout(function() {
									$window.location.href = '#/viewemployee';
								}, 2000);
								}
							else
								{
								$scope.loader=false;
								$scope.employee=null;
								swal("Failed", "Someting Went Wrong", "error");
								$timeout(function() {
									$window.location.href = '#/viewemployee';
								}, 2000);
								}
						}, function myError(response) {
							$scope.myWelcome = response.statusText.status;
							swal("Failed", "Someting Went Wrong", "error");
							$timeout(function() {
								$window.location.href = '#/viewemployee';
							}, 4000);
						});
					} else {
				    swal("Your imaginary file is safe!");
				  }
				});*/
				}
	
	
	
	
	$scope.valueChange=function()
	{
		$scope.employee.fixedSalaryPerYear = $scope.employee.fixedSalaryPerMonth * 12; //tommorow
		$scope.employee.incrementWEFApril = parseInt($scope.employee.incrementWRTRating) + parseInt($scope.employee.rationalizationHRFactor) + parseInt($scope.employee.promotion) + parseInt($scope.employee.retention) ;
	    $scope.employee.incrementAmounts = (parseInt($scope.employee.fixedSalaryPerYear) * parseInt($scope.employee.incrementWEFApril))/100;
	    $scope.employee.incrementAmount=Math.round($scope.employee.incrementAmounts);
	    $scope.employee.newFixedSalaryPerYears = (parseInt($scope.employee.fixedSalaryPerYear))  + $scope.employee.incrementAmount;
	    $scope.employee.newFixedSalaryPerYear= Math.round( $scope.employee.newFixedSalaryPerYears);
	    
//	    $scope.employee.variableAmountCurrentYear = ($scope.employee.newFixedSalaryPerYear * $scope.employee.newVariable)/100;
       $scope.employee.newFixedSalaryPerMonth = Math.round((parseInt($scope.employee.newFixedSalaryPerYear))/12);
	    
	   // $scope.employee.newFixedSalaryPerMonth=Math.round( $scope.employee.newFixedSalaryPerMonths)
	    
	  //  $scope.employee.newVariable = $scope.employee.variable;
	    $scope.employee.newVariablePerYear = (((parseInt($scope.employee.newFixedSalaryPerYear))* (parseInt($scope.employee.newVariable))/100));
	    $scope.employee.basicSalary = Math.round(($scope.employee.newFixedSalaryPerMonth * $scope.basic)/100);
		$scope.employee.hr =Math.round(($scope.employee.basicSalary * 50)/100);
	    $scope.employee.newCTCMonths = 0;
	    $scope.employee.newCTCYears=(parseInt($scope.employee.newFixedSalaryPerYear) +parseInt($scope.employee.newVariablePerYear))
	    $scope.employee.newCTCYear=Math.round($scope.employee.newCTCYears);
	    $scope.employee.newCTCMonth=Math.round($scope.employee.newCTCYear/12);
	    $scope.employee.variableAmountCurrentYear=parseInt(($scope.employee.newCTCYears * 10)/100);
	    $scope.employee.variablePay=$scope.employee.variableAmountCurrentYear;
	    
//	    $scope.employee.newCTCYear = (parseInt($scope.employee.newFixedSalaryPerYear)) +  (parseInt($scope.employee.newVariablePerYear));
	    $scope.employee.netIncreaseYearly = (parseInt($scope.employee.newCTCYear)) - (parseInt($scope.employee.currentCTCPerYear));
	   // $scope.employee.specialAllowance="0";
	    $scope.employee.gratuity= Math.round(($scope.employee.basicSalary/26) * (1.25));
	    $scope.employee.pf= Math.round((parseInt($scope.employee.basicSalary)*12)/100);
	 //   $scope.fixedCtcABCD=parseInt($scope.employee.basicSalary) + parseInt($scope.employee.hr)+ parseInt($scope.employee.specialAllowance)+ parseInt($scope.employee.supplementaryAllowance)+ parseInt($scope.employee.childrenEducationAllowance)+ parseInt($scope.employee.pf) + parseInt($scope.employee.residentTelephone)+ parseInt($scope.employee.attire)+ parseInt($scope.employee.newspaper)+ parseInt($scope.employee.lta)+ parseInt($scope.employee.gratuity);
	   
	    
	    if($scope.employee.carLease=='Yes')
	    	{
	    	$scope.employee.specialAllowance=Math.round($scope.employee.newFixedSalaryPerMonth -(parseInt($scope.employee.basicSalary) + parseInt($scope.employee.hr)+ parseInt($scope.employee.supplementaryAllowance)+ parseInt($scope.employee.childrenEducationAllowance)+ parseInt($scope.employee.pf)+ parseInt($scope.employee.residentTelephone)+ parseInt($scope.employee.attire)+ parseInt($scope.employee.newspaper)+ parseInt($scope.employee.lta)+ parseInt($scope.employee.gratuity))- parseInt($scope.employee.carLeaseAmount));	
	    	}
	    else
	    	{
	    //	Swal.fire("Please change car lease amount to zero");
	    	$scope.employee.specialAllowance=Math.round($scope.employee.newFixedSalaryPerMonth -(parseInt($scope.employee.basicSalary) + parseInt($scope.employee.hr)+ parseInt($scope.employee.supplementaryAllowance)+ parseInt($scope.employee.childrenEducationAllowance)+ parseInt($scope.employee.pf)+ parseInt($scope.employee.residentTelephone)+ parseInt($scope.employee.attire)+ parseInt($scope.employee.newspaper)+ parseInt($scope.employee.lta)+ parseInt($scope.employee.gratuity)));
		    	
	    	}
	    
	    
	    
	    
		}
	$scope.changeIncrementLetter=function()
	{
		console.log($scope.incrementLetterDetailsId);
	}
});

app.controller("viewemployeeController", function($scope, $http, $timeout,$window,sharedProperties) {
	
	$scope.gridOptions = {
			showGridFooter : true,
			multiSelect : false,
			enableFiltering : true,
			enableGridMenu : true,
			enableSelectAll : true,
			exporterMenuPdf : false, // ADD THIS
			exporterCsvFilename : 'employeeList.csv',
			exporterCsvLinkElement : angular.element(document
					.querySelectorAll(".custom-csv-link-location")),
					
			columnDefs : [
					{
						name : 'Sr #',
						field : '<span>{{rowRenderIndex+1}}</span>',
						width : '5%',
						cellTemplate : '<div class="ui-grid-cell-contents">{{grid.renderContainers.body.visibleRowCache.indexOf(row)+1}}</div>'
					},
					{
						name : 'Name',
						field : 'empName',
//						width : '15%'
					},
					{
						name : 'Employee Code',
						field : 'empCode',
//						width : '10%'
					},
					{
						name : 'Department',
						field : 'department',
//						width : '15%'
					},
					{
						name : 'Designation',
						field : 'designation',
//						width : '15%'
					},
					{
						name : 'Edit',
						cellTemplate : '<div style ="text-align : center;"> <button  class=" btn-primary "  ng-click="grid.appScope.modifyEmployee(row.entity)" ><span class="glyphicon glyphicon-pencil" style="margin: 0px;"></span> </button></div>',
						width : '5%'
					},
					{
						name : 'Delete',
						cellTemplate : '<div style ="text-align : center;"> <button  class=" btn-danger"  ng-click="grid.appScope.deleteEmployee(row.entity.id)"><span class="fa fa-trash" style="margin: 0px;"></span> </button></div>',
						width : '5%'
					} ]
		};

//		$scope.viewEmployee = function(data) {
//			sharedProperties.setValue("employeeDetails", data);
//			$window.location.href = "#/view-employee";
//		}
		$scope.modifyEmployee = function(data) {
			sharedProperties.setValue("employeeDetails", data);
			$window.location.href = "#/employee";
		}
		$scope.deleteEmployee = function(data) {
			
			Swal.fire({
				  title: 'Are you sure?',
				  text: "You won't be able to revert this!",
				  type: 'warning',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: 'Yes, delete it!'
				}).then((result) => {
				  if (result.value) {
					  
						Swal.fire({
							  imageUrl: '/Ctool/resources/images/preview-loader.gif',
							  imageHeight: 100,
							  showConfirmButton: false,
							  allowEscapeKey:false,
							  allowOutsideClick:false
							})
							
					  $http({
				        method : "POST",
					        url : "/Ctool/employee/delete",
					        data:data
					    }).then(function mySuccess(response) {
				    	$scope.employeeListData = response.data.object;
				    	$("#example").dataTable().fnDestroy();
				    	$(document).ready(function() {
						    $('#example').DataTable( {
						    	 orderCellsTop: true,
						         fixedHeader: true,
						        dom: 'Bfrtip',
						        buttons: [
						            {
						                extend: 'pdf',
						                footer: false,
						                exportOptions: {
						                     columns: [1,2,3,4,5]
						                 }
						            },
						            {
						                extend: 'csv',
						                footer: false,
						                exportOptions: {
						                	 columns: [1,2,3,4,5]
						                 }
						               
						            },
						            {
						                extend: 'excel',
						                footer: false,
						                exportOptions: {
						                	 columns: [1,2,3,4,5]
						                 }
						            }         
						         ]  
						    } );
						} );
				    	   Swal.fire(
								      'Deleted!',
								      'Employee Deleted Successfully',
								      'success'
								    )
					    }, function myError(response) {
					        $scope.myWelcome = response.statusText;
				    });
				  }
				  else
					  {
					    Swal.fire(
							      'Success !',
							      'Your Data is Safe',
							      'success'
							    )
					  }
				})
			
		}
		$scope.cancel = function() {
			$scope.isFormValid = false;
		}

		$scope.getDataOnLoad = function() {
			
			Swal.fire({
				  imageUrl: '/Ctool/resources/images/preview-loader.gif',
				  imageHeight: 100,
				  showConfirmButton: false,
				  allowEscapeKey:false,
				  allowOutsideClick:false
				})
			
			var res = $http.post('/Ctool/employee/employeeList');
			res.success(function(data, status) {
				Swal.close();
				$scope.gridOptions.data = data.object;
				$scope.employeeListData = data.object;
				
				$(document).ready(function() {
				    $('#example').DataTable( {
				    	 orderCellsTop: true,
				         fixedHeader: true,
				        dom: 'Bfrtip',
				        buttons: [
				            {
				                extend: 'pdf',
				                footer: false,
				                exportOptions: {
				                     columns: [1,2,3,4,5]
				                 }
				            },
				            {
				                extend: 'csv',
				                footer: false,
				                exportOptions: {
				                	 columns: [1,2,3,4,5]
				                 }
				               
				            },
				            {
				                extend: 'excel',
				                footer: false,
				                exportOptions: {
				                	 columns: [1,2,3,4,5]
				                 }
				            }         
				         ]  
				    } );
				} );
			});
		}
//	$scope.viewemployeeInit=function()
//	{
//		$scope.pageloader=true;
//		 $http({
//		        method : "POST",
//		        url : "/Ctool/employee/list"
//		    }).then(function mySuccess(response) {
//		    	$scope.pageloader=false;
//		        $scope.employeeList = response.data.object;
//		    }, function myError(response) {
//		        $scope.myWelcome = response.statusText;
//		    });
//			
//	}
//	
//	
//	$scope.promote = function(promotedata) {
//		$window.location.href = '#/employee';
//		sharedProperties.setValue("promotedata", promotedata);
//	}

	
});


app.controller("bodyController", function($scope, $http, $timeout) {
	
//	$http({
//		method : "POST",
//		url : "/Ctool/employee/profile"
//	}).then(function mySuccess(response) {
//		$scope.profiledetails = response.data.object;
//	}, function myError(response) {
//		$scope.myWelcome = response.statusText;
//	});

	
});


app.controller("employeebulkController", function($scope, $http, $timeout) {

	$scope.uploadbtn = false;
	$scope.uploadspinner = false;

	$scope.uploadFiles = function() {
		
		
		
		Swal.fire({
			  imageUrl: '/Ctool/resources/images/preview-loader.gif',
			  imageHeight: 100,
			  showConfirmButton: false,
			  allowEscapeKey:false,
			  allowOutsideClick:false
			})
			
		$scope.uploadbtn = true;
		$scope.uploadspinner = true;
		var formdata = new FormData();
		formdata.append("file1", image1);
		$http.post("/Ctool/employee/bulk", formdata, {
			transformRequest : angular.identity,
			headers : {
				'Content-Type' : undefined
			}

		}).then(function mySuccess(response) {
			$scope.clientadd = response.data.status;
			if ($scope.clientadd) {
				$scope.pageloader=false;
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
				Swal.close();
				Swal.fire("Data Updated Successfully");
				$scope.message = response.data.message;
			} else {
				Swal.close();
				Swal.fire("Something Went Wrong");	
				$scope.uploadbtn = false;
				$scope.uploadspinner = false;
			}
		}, function myError(response) {
			$scope.pageloader=false;
			Swal.close();
			Swal.fire("Failed", "Something Went Wrong", "error");
			$scope.listerror = response.statusText;
			
		});

	}

});

app.controller("viewClientController", function($scope, $http, $window,
		sharedProperties) {});

app.controller("viewmailController", function($scope, $http) {});
app.controller("enquiryController", function($scope, $http, $timeout) {});

// Contact controller
app.controller("projectController", function($scope, $http, $timeout) {});

app.controller("viewprojectController", function($scope, $http) {});

app.controller("residentialController", function($scope, $http, $timeout) {});

app.controller("viewresidentialController", function($scope, $http) {});

app.controller("commercialController", function($scope, $http, $timeout) {});

app.controller("viewcommercialController", function($scope, $http) {});

app.controller("campaignController", function($scope, $http, $timeout,$window) {});
