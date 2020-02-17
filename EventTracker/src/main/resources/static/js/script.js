/**
 * 
 */
window.addEventListener('load', function(e){
    console.log('document loaded!');
    getEvents();
});

function getEvents(){
    var xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/events');

	xhr.onreadystatechange = function() {

		if (xhr.status < 400 && xhr.readyState === 4) {
			var events = JSON.parse(xhr.responseText);
			displayEvents(events);
		}

		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error(xhr.status + ": " + xhr.responseText);
		}
	};
	xhr.send(null);
};

function displayEvents(events){
    var table = document.createElement('table');
	table.border = 1;
	table.setAttribute('id', 'eventTable');

	var thead = document.createElement('thead');
	table.appendChild(thead);

	var tr = document.createElement('tr');
    var th = document.createElement('th');
	th.textContent = 'ID';
	tr.appendChild(th);

	var th1 = document.createElement('th');
	th1.textContent = 'Name';
	tr.appendChild(th1);

	var th2 = document.createElement('th');
	th2.textContent = 'Time Spent';
	tr.appendChild(th2);

	var th3 = document.createElement('th');
	th3.textContent = 'Date';
    tr.appendChild(th3);
    
    var tableBody = document.createElement('tbody');

    for(let x = 0; x < events.length; x++){
        var tr1 = document.createElement('tr');
        var td = document.createElement('td');
		td.textContent = events[x].id;
		tr1.appendChild(td);

		var td1 = document.createElement('td');
		td1.textContent = events[x].name;
		tr1.appendChild(td1);

		var td2 = document.createElement('td');
		td2.textContent = events[x].timeSpent;
		tr1.appendChild(td2);

		var td3 = document.createElement('td');
		td3.textContent = events[x].date;
        tr1.appendChild(td3);
        
        tableBody.appendChild(tr1);
    }

    table.appendChild(tableBody);
    document.body.appendChild(table);
};
