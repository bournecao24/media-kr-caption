
import requests
import re

class SimpleCrawler:
    def crawl(self, params=None):
# 必须指定UA，否则知乎服务器会判定请求不合法
        url = "https://shimo.im/docs/twXK6CRT6ktctpCD/read"
# 查询参数
# https://shimo.im/docs/twXK6CRT6ktctpCD/read
        params = {"limit": 20, "offset": 0, "include": "data[*].follower_count, gender, is_followed,is_following"}
        headers = {"authority": "www.zhihu.com", "user-agent": "Mozilla/5.0 (WindowsNT 10.0;Win64;x64) "
     "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari / 537.36",
}
        response = requests.get(url, headers=headers, params=params)
        print("请求URL:", response.url)
# 你可以先将返回的响应数据打印出来，拷⻉到 http://www.kjson.com/jsoneditor/ 分析其结构。
        print("返回数据:", response.text)
# 解析返回的数据

        for follower in response.json().get("data"):
            print(follower)
if __name__ == '__main__':
    SimpleCrawler().crawl()
