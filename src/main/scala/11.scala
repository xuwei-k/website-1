object Example11 {

def myPlan: javax.servlet.Filter = ???

// #example1
import unfiltered.jetty.ContextAdder

unfiltered.jetty.Server.http(8080).
  context("/client"){ ctx: ContextAdder =>
    ctx.resources(new java.net.URL(
      """file:../client"""
    )).allowAliases(true)
  }.plan(myPlan).run()
// #example1


// #example2
unfiltered.jetty.Server.http(8080).plan(myPlan).requestLogging("/tmp/access.log").run()
// #example2

}
