/**
 * create by
 * @author hujin 2020/9/12
 */
def process = 'cmd /c dir'.execute()
println process.text