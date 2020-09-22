// GET
def conn = new URL("https://httpbin.org/get").openConnection()
def code = conn.responseCode
println code
if (code == 200) {
    println conn.inputStream.text
}

// POST
def conn = new URL("https://httpbin.org/post").openConnection()
def message = '{"message":"this is a message"}'
conn.requestMethod = 'POST'
conn.doOutput = true
conn.setRequestProperty('Content-Type', 'application/json')
conn.outputStream.write(message.getBytes('UTF-8'))
def responseCode = conn.responseCode
println responseCode
if (responseCode == 200) {
    println conn.inputStream.text
}