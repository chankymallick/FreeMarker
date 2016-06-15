<html>
    <head>
        <title>Analytix Employee Detail</title>
        <script src="assets/codebase2/dhtmlx.js" type="text/javascript"></script> 
        <script src="assets/PieChart_JS.js" type="text/javascript"></script> 
    	<link rel="STYLESHEET" type="text/css" href="assets/codebase2/dhtmlx.css"> 
        <script src="assets/controller.js" type="text/javascript"></script>        
    </head>
    <body onload="main_Method()">       
        <style>
            #Layout_Container,body,html
            {
                width:100%;
                height:100%;
                overflow: hidden;
                margin: 0px auto;                
            }
             .dhxwins_vp_dhx_skyblue div.dhxwin_hdr div.dhxwin_icon.employeeAdd 
                {
			background-image: url(assets/icons/icon.png);
                        background-size: 20px,20px;
		}
             .dhxwins_vp_dhx_skyblue div.dhxwin_hdr div.dhxwin_icon.employeeDelete 
                {
			background-image: url(assets/icons/delete.png);
                        background-size: 20px,20px;
		}  
              .dhxwins_vp_dhx_skyblue div.dhxwin_hdr div.dhxwin_icon.employeeEdit 
                {
			background-image: url(assets/icons/edit.png);
                        background-size: 20px,20px;
		} 
               .dhxwins_vp_dhx_skyblue div.dhxwin_hdr div.dhxwin_icon.employeeView
                {
			background-image: url(assets/icons/view.png);
                        background-size: 20px,20px;
		} 
                 .dhxwins_vp_dhx_skyblue div.dhxwin_hdr div.dhxwin_icon.employeeAddList
                 {
                        background-image: url(assets/icons/add_list.png);
                        background-size: 20px,20px;                     
                 }
                .dhxform_textarea[readonly="true"]
                 {
                        background-color: grey;
                        font-weight: bold;
                        border:none;
                        color:cyan;
                        
                 }
                 .odd_dhx_skyblue
                 {
                     background-color: #e0f8ff !important;
                     color: #34404b;
                     font-weight: bold;
                 }
                 .ev_dhx_skyblue
                 {
                     background-color:#fdffe0 !important;
                     color:#c66200;
                     font-weight: bold;
                 }
                 .dhxform_fs
                 {
                    background-color:f9f9de;
                     
                 }
        </style>              
        <div id="Layout_Container"></div>
    </body>
</html>
