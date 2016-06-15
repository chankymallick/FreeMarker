var normalPieObj;
    var Status_Data = [
	{ Percentage:"20", Status:"PendingReview", color: "#ee3639" },
	{ Percentage:"60", Status:"PendingApproval", color: "#ee9e36" },
	{ Percentage:"10", Status:"Approved", color: "#eeea36" },
	{ Percentage:"10", Status:"Published", color: "#a9ee36" }	
     ];
     var Risk_Data = [
	{ Percentage:"29", Status:"High", color: "#ee3639" },
	{ Percentage:"31", Status:"Medium", color: "#ee9e36" },
	{ Percentage:"40", Status:"Low", color: "#eeea36" }	
     ];
     var Priority_Data = [
	{ Percentage:"45", Status:"High", color: "#ee3639" },
	{ Percentage:"25", Status:"Medium", color: "#ee9e36" },
	{ Percentage:"30", Status:"Low", color: "#eeea36" }
	
     ];
function constructPiechartTemplate(CellObject,PieType,StatusType)
{        
                var pieConfig =({
                    view:PieType,        
                    value:"#Percentage#",
                    color:"#color#",        
                    pieInnerText:"#Percentage#"+"%",
                    tooltip:"#Status#",
                    shadow:0,
                    legend:{ width: 100, align: "right",padding :"10", valign: "middle", marker:{ type: "round", width: 15  }, template: "#Status#" }
                 });
                normalPieObj = CellObject.attachChart(pieConfig);
                normalPieObj.parse(StatusType,"json");
   }
   
   function requirementModuleChart(cellObject,PieType)
   {
       var summaryChartTabber = cellObject.attachTabbar();      
       summaryChartTabber.addTab("status","By Status");
       summaryChartTabber.addTab("priority","By Priority");
       summaryChartTabber.addTab("risk","By Risk");
       constructPiechartTemplate(summaryChartTabber.tabs("status"),PieType,Status_Data);
       summaryChartTabber.tabs("status").setActive();
       summaryChartTabber.attachEvent("onSelect", function(id, lastId){
           if(id=="status"){
               constructPiechartTemplate(summaryChartTabber.tabs("status"),PieType,Status_Data);
           }
           if(id=="priority"){
               constructPiechartTemplate(summaryChartTabber.tabs("priority"),PieType,Priority_Data);
           }
           if(id=="risk"){
               constructPiechartTemplate(summaryChartTabber.tabs("risk"),PieType,Risk_Data);
           }  
            return true;
        });
   }

