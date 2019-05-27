
window.onload = function() {
	  var ctx, data, myBarChart, option_bars;
	  var winLossChart = document.getElementById('radar-chart').getContext('2d');
	  option_bars = {
	    scaleBeginAtZero: true,
	    scaleShowGridLines: true,
	    scaleGridLineColor: "rgba(0,0,0,.05)",
	    scaleGridLineWidth: 1,
	    scaleShowHorizontalLines: true,
	    scaleShowVerticalLines: false,
	    barShowStroke: false,
	    barStrokeWidth: 0,
	    barValueSpacing: 5,
	    barDatasetSpacing: 1,
	  };
	  data = {
	    labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
	    datasets: [
	 {
	        label: "My Second dataset",
	        fillColor: "rgba(34, 167, 240,0.2)",
	        strokeColor: "#22A7F0",
	        pointColor: "#22A7F0",
	        pointStrokeColor: "#fff",
	        pointHighlightFill: "#fff",
	        pointHighlightStroke: "#22A7F0",
	        data: [28, 48, 40, 19, 86, 27, 90]
	      }
	    ]
	  };
	  myBarChart = new Chart(winLossChart).Radar(data, option_bars);
	}



