/**
 * 
 */
$(document).ready(function() {
	var table = $('#datatable-test').DataTable({
		lengthMenu: [ [10, 25, 50, 100, -1], [10, 25, 50, 100, "All"] ],
		pageLength: 10,
		dom: '<"html5buttons"B>lTfgitp',
		colReorder: true,
		buttons: [    
			{ extend: 'colvis',
            		columnText: function ( dt, idx, title ) {
                    return (idx+1)+': '+title;
                }            	
            }    
		]
    });
	
    $('#column-visible').multiselect({
        enableFiltering: true,
        includeSelectAllOption: true,
        selectAllJustVisible: true,
        //Individual Change
        onChange: function(option, checked, select) {
        		if(!checked){            		
        			        			
        			table.column( $(option).val() ).visible( true );
        			
        		}
        		else{
        			
        			table.column( $(option).val() ).visible( false );
        		
        		}
        },
        //Select All 
        onSelectAll: function() {
        		table.columns().visible( false );        
        	},
        	//Deselect All
        	onDeselectAll: function() {
        		table.columns().visible( true );        
        }
    });
    table.columns.adjust().draw( false ); // adjust column sizing and redraw

});
