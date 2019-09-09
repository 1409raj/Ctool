<!-- 
<section class="content">
 <img alt="" src="/Ctool/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
	general form elements
	<div class="box box-primary">
		<div class="box-header with-border">
			<h5>Add Employee Basic Details</h5>
		</div>
		<div class="box-body">
			/.box-header
			form starts
			<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<div class="form-group">

						<form role="form">
							<div class="panel panel-default">
								<div class="panel-heading">Choose File To Upload</div>
								<div class="panel-body">
									<input type="file" file-model="file1"
										class="form-control input-sm" accept=".csv"
										required="required"><br>
									<p><a href="/Ctool/resources/sample/employeeUploadHR.csv" download="employeeBasicDetails.csv">Download Sample Here</a></p>
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<button ng-click="uploadEmployeeBasicDetailsFiles()"
													class="btn btn-primary btn-sm" ng-disabled="uploadbtn">
													<i class="fa fa-upload"></i>&nbsp;Upload &nbsp;<i
														class="fa fa-spinner fa-spin" ng-show="uploadspinner"></i>
												</button>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<div class="callout callout-success callout-custom"
													style="padding: 5px; text-align: center;" ng-show="success">{{message}}</div>
												<div class="callout callout-danger callout-custom"
													style="padding: 5px; text-align: center;" ng-show="error">{{message}}</div>

											</div>
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>

				</div>



			</div>

		</div>
	</div>
	/.row
</section>

 -->