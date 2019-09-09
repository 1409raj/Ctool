
<section class="content" ng-init="viewconfigInit()">
<img alt="" src="/Ctool/resources/image/loading.gif" style="z-index: 4"  ng-show="pageloader" id="pageloader" height="100" width="100">
<div class="box box-primary" style="min-height: 380px;">
 <div class="box-header with-border">
          <h3 class="box-title">Configuration List</h3>

          
        </div>
<div class="box-body">
            <div class="table-responsive mailbox-messages">
              <table id="example1" class="table table-bordered table-striped" >
                <thead style="width: 100%;">
                <tr>
                 <th style="width: 2%;">S.No</th>
                 <th>Assessment Year</th>
                 <th>Designation</th>
                 <th>Department</th>
                  <th>Location</th>
                  <th>HR Factor (%)</th>
                  <th>New Variable (%)</th>
                  <th>Retention Case (%)</th>
                  <th>KRA (%)</th>
                  <th>Extra Ordinary Initiative (%)</th>
                  <th>Behavior Competence (%)</th>
                  
                </tr>
                
                </thead>
                
                <tbody>
               
                <tr ng-repeat="config in configurationList | filter : search">
                 <td>{{$index+1}}</td>
                 <td>{{config.assessmentyear}}</td>
                 <td>{{config.designation}}</td>
                 <td>{{config.department}}</td>
                  <td>{{config.location}}</td>
                  <td>{{config.rationalizationHrFactor}}</td>
                  <td>{{config.newvariable}}</td>
                  <td>{{config.retentioncase}}</td>
                  <td>{{config.kra}}</td>
                  <td>{{config.extraOrdinaryInitiative}}</td>
                  <td>{{config.behaviorCompetence}}</td>
                </tr>
               
                </tbody>
               
              </table>
              </div>
</div>


            </div>
             	
</section>

