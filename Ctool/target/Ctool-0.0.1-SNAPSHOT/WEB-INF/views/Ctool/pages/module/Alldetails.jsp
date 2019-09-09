
   <div class="data-table-area data-table-list" ng-init="getDataOnLoad()">
                        <div class="basic-tb-hd">
                            <h2><i class="fa fa-users"></i>&nbsp;Employees Information</h2>
                         
                        </div>
                          <div class="table-responsive">
                            <table id="example"  class="table table-striped table-bordered">
                            
                           <thead style="width: 100%;">
                <tr>
                 <th >S.No</th>
                 <th>Name</th>
                 <th >Employee Code</th>
                 <th  >Department</th>
                  <th >Designation</th>
                  <th>Location</th>
                  <th>DOJ</th>
                  <th>Total Tenure in company</th>
                  <th>CURRENT FIXED SALARY( PER YEAR)</th>
                  <th>CURRENT FIXED SALARY( PER MONTH)</th>
                  <th>Variable (%)</th>
                  <th>Variable Amount CURRENT YEAR</th>
                  <th>CURRENT  CTC (YEAR)</th>
                  
                  <th>CURRENT  CTC (MONTH)</th>
                  <th>Months  (CURRENT DATE _ DOJ)</th>
                  <th>KRA Rating</th>
                  <th>KRA (75%)</th>
                  <th>Extraordinary Initiatives</th>
                  
                  <th>Extraordinary Initiatives (10%)</th>
                  <th>Behavioural Competence</th>
                  <th>Behavioural Competence (15%)</th>
                  <th>Final Rating of (YEAR)</th>
                  <th>Variable to be disbursed</th>
                  <th>variable (33%)</th>
                  <th>Variable (67%)</th>
                  <th>Variable to be disbursed(Z)</th>
                  <th>Increment w.r.t Rating</th>
                  <th>Rationalisation/HR factor</th>
                  <th>Promotion</th>
                  <th>Retention case</th>
                  <th>Increment w.e.f April (Year)</th>
                  <th>Increment amount</th>
                  <th>NEW FIXED SALARY( PER YEAR)</th>
                  <th>NEW FIXED SALARY( PER MONTH)</th>
                  <th>New Variable( %)</th>
                  <th>New Variable( Per year)</th>
                  <th>NEW CTC (YEAR)</th>
                  <th>Net Increase  (Yearly)</th>
                  <th>New Promotion</th>
                  <th>New Designation</th>
                  <th>Special bonus</th>
                  <th>Created On</th>
                
                </tr>
                
                </thead>
                
                <tbody>
               
                <tr ng-repeat="employee in employeeListData | filter : search">
                 <td>{{$index+1}}</td>
                 <td>{{employee.empName}}</td>
                 <td>{{employee.empCode}}</td>
                  <td>{{employee.department}}</td>
                  <td>{{employee.designation}}</td>
                 <td>{{employee.location}}</td>
                 <td>{{employee.dateOfJoining | date :  "yyyy-MM-dd"}}</td>
                 <td>{{employee.totalTenure}}</td>
                 <td>{{employee.fixedSalaryPerYear}}</td>
                 <td>{{employee.fixedSalaryPerMonth}}</td>
                 <td>{{employee.variable}}</td>
                 <td>{{employee.variableAmountCurrentYear}}</td>
                 <td>{{employee.currentCTCPerYear}}</td>
                 <td>{{employee.currentCTCPerMonth}}</td>
                 <td>{{employee.monthCurrentDateDOJ}}</td>
                 <td>{{employee.kraRating}}</td>
                 <td>{{employee.kra}}</td>
                 <td>{{employee.extraOrdinaryInitiativeRating}}</td>
                 <td>{{employee.extraOrdinaryInitiative}}</td>
                 <td>{{employee.behaviouralCompetenceRating}}</td>
                 <td>{{employee.behaviouralCompetence}}</td>
                 <td>{{employee.finalYearRating}}</td>
                 <td>{{employee.disbursedVariable}}</td>
                 <td>{{employee.variable33}}</td>
                 <td>{{employee.variable67}}</td>
                 <td>{{employee.disbursedVariableZ}}</td>
                 <td>{{employee.incrementWRTRating}}</td>
                 <td>{{employee.rationalizationHRFactor}}</td>
                 <td>{{employee.promotion}}</td>
                 <td>{{employee.retention}}</td>
                 <td>{{employee.incrementWEFApril}}</td>
                 <td>{{employee.incrementAmount}}</td>
                 <td>{{employee.newFixedSalaryPerYear}}</td>
                 <td>{{employee.newFixedSalaryPerMonth}}</td>
                 <td>{{employee.newVariable}}</td>
                 <td>{{employee.newVariablePerYear}}</td>
                 <td>{{employee.newCTCYear}}</td>
                 <td>{{employee.netIncreaseYearly}}</td>
                 <td>{{employee.newPromotion}}</td>
                 <td>{{employee.newDesignation}}</td>
                 <td>{{employee.specialBonus}}</td>
                  <td>{{employee.createdOn | date :  "yyyy-MM-dd" }}</td>
             
                </tr>
               
                </tbody>
               
                            </table>
                            </div>
                        </div>
