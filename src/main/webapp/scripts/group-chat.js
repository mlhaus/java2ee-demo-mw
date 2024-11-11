let wsProtocol = "ws://";
if(window.location.protocol === "https:") {
    wsProtocol = "wss://";
}
const wsUri = wsProtocol + document.location.host + document.location.pathname + "/endpoint";
const websocket = new WebSocket(wsUri);

websocket.onopen = function(event) {
    // console.log("Opened websocket: " + wsUri)
};

websocket.onmessage = function(event) {
    updateTextArea(event.data, "in");
};

websocket.onclose = function(event) {

};

websocket.onerror = function(event) {
    displayError("ERROR: " + event.data + ". See the browser's console for more details.");
};

function displayError(msg) {
    let errText = document.getElementById("errorText");
    errText.innerHTML = msg;
}

const messageForm = document.getElementById("messageForm");
messageForm.addEventListener("submit", function(event) {
    event.preventDefault();
    // Remove any previous error message
    displayError("");
    // Get the user name
    const userName = document.getElementById("userName").value;
    if (userName === "") {
        displayError("Name is required");
        return;
    }
    // Get the test of the message.  If the message is blank, use "..."
    const message = document.getElementById("message").value;
    if (message === "") {
        message = "...";
    }
    // Build a JSON object and convert it to a string so it can be sent
    const json = JSON.stringify({
        "name": userName,
        "message": message
    });
    // Send the message
    sendText(json);
    // Set the message text field to blank so it is ready for the next message
    prepMessageBox();
    // Update the textarea just like we would with an incoming message
    updateTextArea(json, "out");
});

function isOpen(websocket) {
    return websocket.readyState === websocket.OPEN
}

// Send the message to the server endpoint and log the activity to the console
function sendText(json) {
    if(isOpen(websocket)) {
        console.log("sending text: " + json);
        websocket.send(json);
    }
}

// Clear any existing text from the message box and set focus there
function prepMessageBox() {
    var messageBox = document.getElementById("message");
    messageBox.value = "";
    messageBox.focus();
}

/*
 * Update the textarea by appending the supplied text to the text that is
 * already there.  The text shows up as JSON, so it has to be parsed into
 * a JSON object to let us retrieve the data.
 */
function updateTextArea(data, inOut) {
    // Parse the data as JSON so the fields can be accessed
    var json = JSON.parse(data);
    // Use the JSON notation to retrieve the data fields
    var name = json.name;
    var message = json.message;
    // Build the text to display then show it
    var out = (inOut == "in") ? "<div class=\"in\">" : "<div class=\"out\">";
    out += "<p>" + message + "</p><span>";
    out += (inOut == "in") ? name  : "Me";
    out += "</span></div>"
    var textArea = document.getElementById("messages");
    textArea.innerHTML = textArea.innerHTML + out;
    // Attempt to move the scrolling of the textarea to show the lowest item
    // The effectiveness of this varies by browser
    textArea.scrollTop = textArea.scrollHeight;
    // Logging only helps when you have the browser's developer tools open
    console.log("Writing: " + data);
}