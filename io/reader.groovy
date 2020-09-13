/**
 * create by
 * @author hujin 2020/9/9
 */
println "Please enter your favorite sports team: "

String team
System.in.withReader { reader ->
    team = reader.readLine()
}

println "Your favorite team is: $team"