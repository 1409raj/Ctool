<section class="content" ng-init="configInit()">

<div class="box box-primary">
 <div class="box-header with-border">
          <h3 class="box-title">Configuration</h3>

          
        </div>

<div class="box-body">

                <form role="form" name="myForm">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label>Band</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Band" readonly="readonly"  ng-model="config.band"  required="required">
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Department</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-id-card-o"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Department" readonly="readonly"  ng-model="config.departments.name"  required="required">
						      
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Location</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Location" readonly="readonly" ng-model="config.location"  required="required">
								
							</div>
						</div>
					</div>
					
						<div class="col-md-3">
						<div class="form-group">
							<label>Rating</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-star-o"></i></span>
								<select class="form-control input-sm" placeholder="Home address" ng-model="config.address"  required="required">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				
								<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label>Promoted</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-map-marker"></i></span>
								<select class="form-control input-sm"  ng-model="config.area"  required="required">
				 <option>Yes</option>
				 <option>No</option>
							</select>
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>AR (Current)</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-rupee"></i></span>
								<input type="text" class="form-control input-sm"  ng-model="config.aadhar"  required="required" placeholder="AR (Current)">
							</div>
						</div>
					</div>
					
						<div class="col-md-3">
						<div class="form-group">
							<label>HR increase Amount</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-rupee"></i></span>
								<input type="text" class="form-control input-sm"  placeholder="HR increase Amount" ng-model="config.aadhar"  required="required">
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Incentive Amount</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-rupee"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Incentive Amount" ng-model="config.address"  required="required">
								
							</div>
						</div>
					</div>
					
					
				</div>
				
				
								<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label>Other Increment Amount</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-rupee"></i></span>
								<input type="text" class="form-control input-sm" placeholder="Other Increment Amount" ng-model="config.address"  required="required">
								
							</div>
						</div>
					</div>
					
					<div class="col-md-3">
						<div class="form-group">
							<label> New AR (Salary)</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-rupee"></i></span>
								<input type="text" class="form-control input-sm" placeholder=" New AR (Salary)"  ng-model="config.aadhar"  required="required">
							</div>
						</div>
					</div>
					
						
					
					
					
					
				</div>
				
				
				<div class="box-footer with-border">
					<div class="col-md-5">
					<div class="callout callout-success callout-custom" style="padding: 5px; text-align:center;" ng-show="success">{{message}}</div>
					<div class="callout callout-danger callout-custom" style="padding: 5px; text-align:center;" ng-show="error">{{message}}</div>
					</div>
					
			<div class="col-md-2 pull-right">
						<button class="btn btn-danger btn-sm" ng-click="reset()"><i class="fa fa-refresh"></i> &nbsp; Reset</button>
						<button class="btn btn-primary btn-sm" ng-click="save()"  ng-disabled="myForm.$invalid"><i class="fa fa-save"></i>  &nbsp; Save</button>
					</div>
				
		</div>
				
			</form>
              

</div>

</div>
           
		</section>

