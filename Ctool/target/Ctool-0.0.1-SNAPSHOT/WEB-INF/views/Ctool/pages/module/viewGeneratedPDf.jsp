
		
   <div class="data-table-area data-table-list" ng-init="getDataOnLoad()">
                        <div class="basic-tb-hd">
                            <h2><i class="fa fa-file-pdf-o text-red"></i>&nbsp;Document Information</h2>
                         
                        </div>
                        
                         <div class="row">
                                       <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                       <div class="form-example-int">
                            <div class="form-group">
                                
                                <div class="nk-int-st">
                                    <input type="text" class="form-control input-sm" placeholder="Type to search" ng-model="search">
                                </div>
                            </div>
                        </div>
                        </div>
                                       </div>
                          <div class="table-responsive">
                            <table id="#example"  class="table table-striped">
                            
			<thead>
			<tr>
			<th>S.no</th>
			<th>Employees Name</th>
			<th>Employees Code</th>
			<th>Created On</th>
			<th>Download</th>
			</tr>
			</thead>
			 <tr ng-if="pdfList.length=='0'">
                <td colspan="5" style="text-align: center;">No Data Available</td>
                </tr>
			
			
				<tr ng-repeat="x in pdfList | filter:search">
					<td>{{$index+1}}</td>
					<td>{{x.empName}}</td>
					<td>{{x.empCode}}</td>
					<td>{{x.createdOn | date :  "yyyy-MM-dd hh:mm:ss" }}</td>
					<td><a href="{{x.fileName}}" download target="_blank"><i class="fa fa-file-pdf-o" style="color: red;"></i></a> | <a href=""  ng-click="pdftoword(x.fileName)"><i class="fa fa-file-excel-o" style="color: green;"></i></a></td>
				</tr>
			</table>

		</div>
	</div>

