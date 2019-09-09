
<div class="data-table-area data-table-list" ng-init="slabVariableInit()">
 <div class="basic-tb-hd">
                            <h2><i class="fa fa-star-o"></i>&nbsp;Rating Variable Non RoofTop(67%)</h2>
                         
                        </div>
                          <div class="table-responsive">
            
              <table id="example1" class="table table-bordered table-striped" >
                <thead style="width: 100%;">
                <tr>
                 <th style="width: 2%;">S.No</th>
                 <th>Rating Minimum</th>
                 <th>Rating Maximum</th>
                 <th>Variable ( 67 % )</th>
                  <th>Created On</th>
                  <th>Modified On</th>
                  <th>Action</th>
                </tr>
                
                </thead>
                <tbody>
               
                <tr ng-repeat="ratingvariable in ratingvariableList | filter : search">
                 <td>{{$index+1}}</td>
                 <td>{{ratingvariable.ratMin}}</td>
                 <td>{{ratingvariable.ratMax}}</td>
                  <td>{{ratingvariable.variable}}</td>
                  <td>{{ratingvariable.createdOn | date :  "yyyy-MM-dd" }}</td>
                  <td>{{ratingvariable.modifiedOn | date :  "yyyy-MM-dd" }}</td>
                  <td><button class="btn btn-success btn-xs" ng-model="ratingvariable.checked" ng-click="editslabVariable(ratingvariable)"><i class="fa fa-edit"></i></button></td>
                </tr>
               
                </tbody>
               
              </table>
              </div>
</div>

