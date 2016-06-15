/*
 By Masaddat Mallick
 Analytix Data Service
 */
var Dhtmlx_Toolbar;
var Dhtmlx_Employee_Window;
var Dhtmlx_Employee_Grid;
var Dhtmlx_Page_Layout;
var DhtmlxEmployeeForm;

function main_Method(){
    layoutIntialization();
    toolBarInitialization();
    gridInitialization();
}

function layoutIntialization(){
    Dhtmlx_Page_Layout = new dhtmlXLayoutObject({
        parent: "Layout_Container",
        pattern: "3J",
        cells:
                [
                    {id: "a", text: "Requirement Workshop", height: 370,width:300},
                    {id: "b", text: "Reqiurement Details"},
                    {id: "c", text: "Summary",width:300}
                ]
    });
}

function toolBarInitialization(){    
        Dhtmlx_Toolbar = Dhtmlx_Page_Layout.attachToolbar();
        Dhtmlx_Toolbar.loadStruct("assets/XML_Files/toolbardata.xml");
        addToolBarEvents();
}
function addToolBarEvents()
{
    Dhtmlx_Toolbar.attachEvent("onClick", function (toolbarButtonId) {
        if (toolbarButtonId === "normalPie") {
            windowInitialization('Normal Pie');
            newChartWindow("pie");
        }
        if (toolbarButtonId === "Pie3d") {
            windowInitialization('3D Pie Chart');
            newChartWindow("pie3D");
        }
        if (toolbarButtonId === "donutPie") {
            windowInitialization('Donut Pie Chart');
            newChartWindow("donut");
        }
    });
}
function gridInitialization(){
    Dhtmlx_Employee_Grid = Dhtmlx_Page_Layout.cells("b").attachGrid();
    Dhtmlx_Employee_Grid.setHeader("Project Id,Total Mappings,Project Name, Color", ["text-align:left", "text-align:left","text-align:left", "text-align:left"]);
    Dhtmlx_Employee_Grid.setInitWidths("100,100,350,200");
    Dhtmlx_Employee_Grid.setColAlign("left,left,left,left");   
    Dhtmlx_Employee_Grid.init();   
   var  data={
    rows:[
        { id:1, data: ["1","20", "Test Project", "#ee3639"]},
        { id:2, data: ["2","30", "Demo Project", "#ee9e36"]},
        { id:3, data: ["3","50", "BCBS Project", "#eeea36"]},
        { id:4, data: ["4","40", "SQL Project", "#a9ee36"]},
        { id:5, data: ["5","70", "Hadoop Mappings", "#36d3ee"]},
        { id:6, data: ["6","80", "MySql Mappings", "#367fee"]},
        { id:7, data: ["7","60", "JSON Maps", "#9b36ee"]}    
    ]
};
Dhtmlx_Employee_Grid.parse(data,"json")
requirementModuleChart(Dhtmlx_Page_Layout.cells("c"),"pie")
 Dhtmlx_Page_Layout.cells("c").showHeader();

}
function windowInitialization(Header){
    Dhtmlx_Employee_Window = new dhtmlXWindows();
    Dhtmlx_Employee_Window.createWindow("CommonWindow", 400, 50, 600, 500);
    Dhtmlx_Employee_Window.window("CommonWindow").setModal(true);
    Dhtmlx_Employee_Window.window("CommonWindow").center();
    Dhtmlx_Employee_Window.window("CommonWindow").setText(Header);
    Dhtmlx_Employee_Window.window("CommonWindow").button("park").disable();
    Dhtmlx_Employee_Window.window("CommonWindow").button("minmax").disable();
    Dhtmlx_Employee_Window.window("CommonWindow").denyResize();
}
function newChartWindow(pieType){
    requirementModuleChart(Dhtmlx_Employee_Window.window("CommonWindow"),pieType,Status_Data);
    Dhtmlx_Employee_Window.window("CommonWindow").setIconCss("employeeAddList");
}
