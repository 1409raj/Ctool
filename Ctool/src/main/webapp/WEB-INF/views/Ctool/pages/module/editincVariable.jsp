
    <!-- Form Examples area start-->
    <div class="form-example-area">
        <div class="container-fluid">
            <div class="row">
            <form role="form" name="myForm">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="form-example-wrap">
                        <div class="cmp-tb-hd">
                            <h2>Add Increment Variable</h2>
                           
                        </div>
                        <div class="row">
                                <div class="col-md-3">
						<div class="form-group">
							<label>Rating Minimum</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-star-o"></i></span>
								<input type="text" class="form-control" ng-model="inc.ratMin" name="ratMin"   max="3"  required only-digits>
							
							</div>
						</div>
					
                            </div>
                        
                         <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                              <div class="form-group">
							<label>Rating Maximum</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-star-o"></i></span>
								<input type="text" class="form-control " ng-model="inc.ratMax"  name="ratMax" max="3"  required only-digits>
									
							</div>
						</div>
                            </div>
                            
                            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                           <div class="form-group">
							<label>Variable (%)</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="number" class="form-control "
									placeholder="Variable" 
									ng-model="inc.variable" name="variable" required>
							</div>
						</div>
                            </div>
                              <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                           <div class="form-group">
							<label>&nbsp;</label>
							<div class="input-group">
							
							<button class="btn btn-success notika-btn-success" ng-click="addincVariableRating()" ng-disabled="vars.ratMin > vars.ratMax || myForm.$invalid "><i class="fa fa-save"></i>&nbsp;&nbsp;Submit</button>
							</div>
						</div>
                            </div>
                        </div>
                        
                        <div class="row" ng-if="inc.ratMin > inc.ratMax" style="text-align: center;color: red;font-weight: bold;">
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