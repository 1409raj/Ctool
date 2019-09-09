<section class="content"  ng-init="getDataOnLoad()">
	<img alt="" src="/Ctool/resources/image/loading.gif" style="z-index: 4"
		ng-show="loader" id="pageloader" height="100" width="100">
	<div class="box box-primary">
	
	<div class="box-header with-border">
	<div class="box-titile">
	Create Slab
	</div>
	</div>
			<div class="box-body">
		
		<form role="form" name="myForm">
				<div class="row">
				<div class="col-md-3">
						<div class="form-group">
							<label>Designation</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<select class="form-control input-sm" ng-model="slab.designation" required>
									<option value="Senior Vice President">Senior Vice President</option>
									<option value="Vice President">Vice President</option>
								
									<option value="Sr GM/ AVP">Sr GM/ AVP</option>
									<option value="General Manager">General Manager</option>
									<option value="Additional General Manager">Additional General Manager</option>
									<option value="Assistant General Manager">Assistant General Manager</option>
									<option value="Chief Manager">Chief Manager</option>
									<option value="Senior Manager">Senior Manager</option>
									<option value="Deputy Manager">Deputy Manager </option>
									<option value="Senior Lead Engineer">Senior Lead Engineer</option>
									<option value="Assistant Manager">Assistant Manager</option>
									<option value=" Lead Engineer"> Lead Engineer</option>
									<option value="Senior Engineer">Senior Engineer </option>
									
									<option value="Engineer / Executive">Engineer / Executive</option>
									<option value="Executive Assistant . Officer">Executive Assistant . Officer</option>
									</select>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Basic (%)</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="number" class="form-control input-sm"
									placeholder="Basic (%)" 
									ng-model="slab.basic" required>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>HRA (%)</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control input-sm"
									placeholder="HRA (%)" 
									ng-model="slab.hra" required>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<label>Supplementary Allowance</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<input type="text" class="form-control input-sm"
									placeholder="Supplementary Allowance" 
									ng-model="slab.supplementaryAllowance" required>
							</div>
						</div>
					</div>
					
					
					<div class="col-md-3">
						<div class="form-group">
							<label>Assessment Year</label>
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<input type="text" class="form-control input-sm"
									placeholder="Assessment Year" 
									ng-model="slab.assessmentYear" required>
							</div>
						</div>
					</div>
					</div>
					</form>
					</div>
				<div class="box-footer with-border">
				<div class="row">
				<div class="col-md-3">
				<div class="form-group">
				
				<button class="btn btn-primary btn-sm" ng-click="addSlab()">Save</button>
				</div>
				
				</div>
				
				</div>
				
		</div>
	</div>
</section>

