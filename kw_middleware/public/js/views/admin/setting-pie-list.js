/* Copyright (C) KWI <http://www.kwinternational.com> */
$(document).ready( function() {
	refresh();
});

/**
 * Refresh the Pie charts data
 * @function refresh
 * 
 */
	function refresh() {
	
    var url = $('#hd_define').data('refresh-link');
    
    $.ajax({    
	    type: 'POST',
	    url: url,
	    headers: {
	        'X-Requested-With': 'XMLHttpRequest',
	        'X-CSRF-TOKEN' : $('meta[name="csrf-token"]').attr('content')
	    },
	    dataType: 'json',
		cache: false,
		contentType: false,
		processData: false,
	    success: function(data) {
	        var myChart = echarts.init(document.getElementById('main')); 
	        option = {
	        	    title : {
	        	        text: 'Users Activation',
	        	        subtext: 'Number of Users',
	        	        x:'center'
	        	    },
	        	    tooltip : {
	        	        trigger: 'item',
	        	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	        	    },
	        	    legend: {
	        	        orient : 'vertical',
	        	        x : 'left',
	        	        data:['Deleted','Activated','Non-Activated']
	        	    },
	        	    calculable : true,
	        	    series : [
	        	        {
	        	            name:'Users',
	        	            type:'pie',
	        	            radius : '75%',
	        	            center: ['50%', '60%'],
	        	            data:[
	        	                {value:data[0], name:'Activated'},
	        	                {value:data[1], name:'Non-Activated'},
	        	                {value:data[2], name:'Deleted'}
	        	            ]
	        	        }
	        	    ]
	        	},
	        
	        // Load data into the ECharts instance 
	        myChart.setOption(option); 
	    },
	    
	    error: function(error_message) {
	        show_message('Fail', JSON.stringify(error_message), 'error', 'OK');
	        
	    }
    });
}