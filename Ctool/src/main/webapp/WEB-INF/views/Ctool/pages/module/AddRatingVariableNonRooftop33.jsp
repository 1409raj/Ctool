
    <!-- Form Examples area start-->
    <div class="form-example-area" ng-init="init()">
        <div class="container-fluid">
            <div class="row">
            <form role="form" name="myForm">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="form-example-wrap">
                        <div class="cmp-tb-hd">
                            <h2>Company Variable Non RoofTop (33%)</h2>
                           
                        </div>
                        <div class="row">
                       <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
                           <div class="form-group">
							<label>Company Variable (33 % )</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="number" class="form-control "
									placeholder="Variable" 
									ng-model="vars.variable" name="variable" required only-digit>
							</div>
						</div>
                            </div>
                              <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
                           <div class="form-group">
							<label>&nbsp;</label>
							<div class="input-group">
							
							<button class="btn btn-success notika-btn-success" ng-click="addnonRoofTopVariable()" ng-disabled="vars.ratMin > vars.ratMax || myForm.$invalid "><i class="fa fa-save"></i>&nbsp;&nbsp;Submit</button>
							</div>
						</div>
                            </div>
                            
                             <div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
                           <div class="form-group">
							
							     <div class="table-responsive">
            
              <table id="example1" class="table table-bordered table-striped" >
                <thead style="width: 100%;">
                <tr>
                 <th style="width: 2%;">S.No</th>
                 <th>Variable ( 33 % )</th>
                  <th>Created On</th>
                  <th>Modified On</th>
                  <th>Action</th>
                </tr>
                
                </thead>
                <tbody>
               
                <tr ng-repeat="ratingvariable in ratingvariableListnonRooftop | filter : search">
                 <td>{{$index+1}}</td>
               
                  <td>{{ratingvariable.variable}}</td>
                  <td>{{ratingvariable.createdOn | date :  "yyyy-MM-dd" }}</td>
                  <td>{{ratingvariable.modifiedOn | date :  "yyyy-MM-dd" }}</td>
                  <td><button class="btn btn-success btn-xs" ng-model="ratingvariable.checked" ng-click="edit(ratingvariable)"><i class="fa fa-edit"></i></button></td>
                </tr>
               
                </tbody>
               
              </table>
              </div>
						</div>
                            </div>
                        </div>
                        
                        <div class="row" ng-if="vars.ratMin > vars.ratMax" style="text-align: center;color: red;font-weight: bold;">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="alert-inner">
                        
                        <div class="alert-list">
                         
                             <div class="alert alert-warning alert-dismissible" role="alert" style="text-align: center;">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true"><i class="notika-icon notika-close"></i></span></button>
                                Minimum rating must be smaller than Maximum rating ?
                            </div>
                           
                        </div>
                    </div>
                </div>
            </div>
                      
                    </div>
                </div>
                </form>
            </div>
        
        </div>
    </div>
    <!-- Form Examples area End-->