import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient

/**
 * create by
 * @author hujin 2020/9/13
 */
@Grab('org.codehaus.groovy.modules.http-builder:http-builder:0.7.2')

def base = 'http://127.0.0.1:44848'
def client = new RESTClient(base)
def endpoint = '/geodata/v3/rastileset/creation?'
def tilesetName = URLEncoder.encode('影像-Test-20200723-HbasePartTest', 'UTF-8')
endpoint += 'tilesetName=' + tilesetName
endpoint += '&supportHalfTileMerge=1'
endpoint += '&encoding=utf-8'
client.contentType = ContentType.JSON
client.post(path: endpoint)