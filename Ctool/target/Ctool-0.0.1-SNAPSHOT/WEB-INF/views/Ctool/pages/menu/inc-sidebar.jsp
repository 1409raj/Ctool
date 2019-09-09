<!-- 
 <ul class="sidebar-menu tree" ng:controller="NavigationController"  data-widget="tree" ng-cloak>
        <li ng-repeat="item in items" ng-if="item.chidItems.length == null" ng-class="{'active': item.id == states.activeItem}" ng-click="states.activeItem=item.id">
          <a  href={{item.link}}>
            <i class="{{item.icon}}"></i> <span>&nbsp;{{item.title}}</span>
            <span class="pull-right-container-fluid" ng-if="item.chidItems.length> '0'">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
        </li>
         <li class="treeview" ng-repeat="item in items" ng-if="item.chidItems.length > '0'" ng-click="states.activeItem=item.id">
          <a  href={{item.link}}>
            <i class="{{item.icon}}"></i>&nbsp;<span>{{item.title}}</span> 
            <span class="pull-right-container-fluid" ng-if="item.chidItems.length> '0'">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu"  style="display: none;">
            <li class="active" ng-repeat="category in item.chidItems">
            <a href={{category.link}}><i class={{category.icon}}></i>&nbsp;{{category.title}}</a></li>
          </ul>
        </li>
        </ul> 
  -->
 <!-- Mobile Menu end -->
    <!-- Main Menu area start-->
    <div class="main-menu-area mg-tb-40" ng:controller="NavigationController" ng-cloak>
        <div class="container-fluid">
            <div class="row pull-right">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro" style="padding-right: 20px;">
                        <li ng-repeat="item in items" ng-if="item.chidItems.length == null" ng-class="{'active': item.id == states.activeItem}" ng-click="states.activeItem=item.id">
                        <a  href={{item.link}} ><i class="{{item.icon}}"></i> {{item.title}}</a>
                        </li>
                        <li class="dropdown" ng-repeat="item in items" ng-if="item.chidItems.length > '0'" ng-click="states.activeItem=item.id">
    <a class="dropdown-toggle" data-toggle="dropdown" href=""><i class="{{item.icon}}"></i>&nbsp;{{item.title}}
    <span class="caret"></span></a>
    <ul class="dropdown-menu ">
      <li ng-repeat="category in item.chidItems"><a href={{category.link}}><i class={{category.icon}}></i>&nbsp;{{category.title}}</a></li>
    </ul>
 
                    </ul>
       
                </div>
            </div>
        </div>
    </div>
    
    
    
      