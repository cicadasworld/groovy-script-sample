import math
import os
from urllib import request
from urllib import parse
from http.client import HTTPConnection


class TilesDownloader(object):
    def __init__(self, lat_s, lng_s, lat_e, lng_e, zoom=12, tile_size=256):
        self.lat_s = lat_s
        self.lng_s = lng_s
        self.lat_e = lat_e
        self.lng_e = lng_e
        self.zoom = zoom
        self.tile_size = tile_size

        self._generate_xy()

    def _generate_xy(self):
        self._x_s, self._y_s = self._convert_latlng_to_xy(self.lat_s, self.lng_s)
        self._x_e, self._y_e = self._convert_latlng_to_xy(self.lat_e, self.lng_e)

    def _convert_latlng_to_xy(self, lat, lng):
        tiles_count = 1 << self.zoom

        _x = (self.tile_size / 2 + lng * self.tile_size / 360.0) * tiles_count // self.tile_size
        sin_y = math.sin(lat * (math.pi / 180.0))
        _y = ((self.tile_size / 2) + 0.5 * math.log((1 + sin_y) / (1 - sin_y)) *
                   -(self.tile_size / (2 * math.pi))) * tiles_count // self.tile_size

        return int(_x), int(_y)

    def download(self):
        tileset_name = '全球影像'
        escape_name = parse.quote('全球影像')

        for x in range(0, self._x_e + 1 - self._x_s):
            for y in range(0, self._y_e + 1 - self._y_s):
                url = '/maps/gts/tms/v1/' + escape_name + '/tile/' + str(self._x_s + x) + '/' + str(self._y_s + y) + '/' + str(self.zoom)

                current_tile = tileset_name + '_' + str(self.zoom) + '_' + str(self._y_s + y) + '_' + str(self._x_s + x) + '.jpg'
                print(current_tile)

                host = '127.0.0.1:80'
                conn = HTTPConnection(host)
                conn.request("GET", url)
                ack = conn.getresponse()
                if ack.status == 200:
                	request.urlretrieve('http://' + host + url, current_tile)


def main():
    try:
        md = TilesDownloader(85, -180, -85, 180, 2)
        # md = TilesDownloader(41.083364, 115.386594, 39.435414, 117.575619, 15) # 北京地区
        md.download()
    except Exception as e:
        pass


if __name__ == '__main__':
    main()