
var socket = null;

function connect() {
    socket = new SockJS('/ws');
    var stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        if (frame.command === 'CONNECTED') {
            stompClient.subscribe('/topic/massages', function (massage) {
                onMassageReceived(massage)
            });
        }

    })
}

function onMassageReceived(payload) {
    var massageArea = document.getElementById("chat");
    var massage = JSON.parse(payload.body);

    var massageElement = document.createElement('li');
    var textElement = document.createElement('p');
    var massageText = document.createTextNode(massage.username+':'+ massage.massage);
    textElement.appendChild(massageText);
    massageElement.appendChild(textElement);

    massageArea.appendChild(massageElement)
    massageArea.scrollTop = massageElement.scrollHeight;
}

