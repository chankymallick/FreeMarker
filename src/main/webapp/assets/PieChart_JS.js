var normalPieObj;
var pie3dObj;
var donutPieObj;
function normalPie(CellObject,PieType)
{    
    var Mapping_Data = [
	{ Mappings:"20", ProjectName:"Test Project", color: "#ee3639" },
	{ Mappings:"30", ProjectName:"Demo Project", color: "#ee9e36" },
	{ Mappings:"50", ProjectName:"BCBS Project", color: "#eeea36" },
	{ Mappings:"40", ProjectName:"SQL Project", color: "#a9ee36" },
	{ Mappings:"70", ProjectName:"Hadoop Mappings", color: "#36d3ee" },
	{ Mappings:"80", ProjectName:"MySql Mappings", color: "#367fee" },
	{ Mappings:"60", ProjectName:"JSON Maps", color: "#9b36ee" }
     ];
                var pieConfig =({
                    view:PieType,        
                    value:"#Mappings#",
                    color:"#color#",
                    label:"#ProjectName#",
                    pieInnerText:"#Mappings#",
                    tooltip:"#ProjectName#",
                    shadow:0        
                 });
                normalPieObj = CellObject.attachChart(pieConfig);
                normalPieObj.parse(Mapping_Data,"json");
   }



