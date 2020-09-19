@groovy.transform.builder.Builder
class Message {
    String from, to, subject, body
}

def message = Message
        .builder()
        .from("from@from.com")
        .to("to@to.com")
        .subject("Sample")
        .body("Groovy rocks")
        .build()

assert message.body == 'Groovy rocks'
assert message.from == 'from@from.com'
assert message.to == 'to@to.com'
assert message.subject == 'Sample'