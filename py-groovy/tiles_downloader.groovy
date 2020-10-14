import java.nio.file.Files
import java.nio.file.Paths

/**
 * Created by hujin on 2020/10/12
 */

def tilesDownloader = new TilesDownloader(85, -180, -85, 180, 2)
//def tilesDownloader = new TilesDownloader(41.083364, 115.386594, 39.435414, 117.575619, 18) // 北京地区
tilesDownloader.download()

class TilesDownloader {
    int zoom = 12, tileSize = 256
    int xStart, yStart, xEnd, yEnd
    String HOST = "127.0.0.1:80"
    String tilesetName = "全球影像"
    String encodedTilesetName = URLEncoder.encode("全球影像", "UTF-8")

    TilesDownloader(double latStart, double lngStart, double latEnd, double lngEnd, int zoom) {
        this.zoom = zoom
        (xStart, yStart) = convertLatLngToXY(latStart, lngStart)
        (xEnd, yEnd) = convertLatLngToXY(latEnd, lngEnd)
    }

    def convertLatLngToXY(double lat, double lng) {
        int tileCount = 1 << zoom

        double siny = Math.sin(lat * Math.PI / 180)
        siny = Math.min(Math.max(siny, -0.9999), 0.9999)
        double wlat = tileSize * (0.5 - Math.log((1 + siny) / (1 - siny)) / (4 * Math.PI))
        double wlng = tileSize * (0.5 + lng / 360)

        int x = (int) Math.floor(wlng * tileCount / tileSize)
        int y = (int) Math.floor(wlat * tileCount / tileSize)

        return [x, y]
    }

    void download() {
        for (int i = 0; i < xEnd + 1 - xStart; i++) {
            for (int j = 0; j < yEnd + 1 - yStart; j++) {
                String url = "http://" + HOST + "/maps/gts/tms/v1/" + encodedTilesetName + "/tile/" + (xStart + i) + "/" + (yStart + j) + "/" + zoom
                String currentTile = tilesetName + "_" + zoom + "_" + (yStart + j) + "_" + (xStart + i) + ".jpg"
                println currentTile
                try {
                    InputStream is = new URL(url).openStream()
                    Files.copy(is, Paths.get(currentTile))
                } catch (Exception e) {
                    // ignore
                }
            }
        }
    }
}