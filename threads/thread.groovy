/**
 * create by
 * @author hujin 2020/9/9
 */
def t = new Thread() {/* do something */}
t.start()

Thread.start { /* do something */ }
Thread.start('thread-name') { /* do something */ }

Thread.startDaemon { /* do something */ }
Thread.startDaemon('thread-name') { /* do something */ }