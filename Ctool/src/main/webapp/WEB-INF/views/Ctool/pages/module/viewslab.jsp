
<div class="data-table-area data-table-list" ng-init="viewslabInit()">
<div class="basic-tb-hd">
                            <h2><i class="fa fa-star-o"></i>&nbsp;Designation</h2>
                         
                        </div>
                          <div class="table-responsive">
            
              <table id="example1" class="table table-bordered table-striped" >
                <thead style="width: 100%;">
                <tr>
                 <th style="width: 2%;">S.No</th>
                 <th>Assessment Year</th>
                 <th>Designation</th>
                 <th>HRA (%)</th>
                  <th>BASIC (%)</th>
                  <th>SUPPLEMENTARY ALLOWANCE</th>
                  <th>Created On</th>
              <!--     <th>Action</th> -->
                </tr>
                
                </thead>
                
                <tbody>
               
                <tr ng-repeat="slab in slabList | filter : search">
                 <td>{{$index+1}}</td>
                 <td>{{slab.assessmentYear}}</td>
                 <td>{{slab.designation}}</td>
                  <td>{{slab.hra}}</td>
                  <td>{{slab.basic}}</td>
                  <td>{{slab.supplementaryAllowance}}</td>
                  <td>{{slab.createdOn | date :  "yyyy-MM-dd" }}</td>
            <!--       <td><button class="btn btn-success btn-xs" ng-model="slab.checked" ng-click="editConfig(slab)"><i class="fa fa-edit"></i></button> | <button class="btn btn-danger btn-xs" ng-model="slab.checked" ng-click="deleteSlab(slab)"><i class="fa fa-trash"></i></button></td>
             -->    </tr>
               
                </tbody>
               
              </table>
              </div>
</div>


          