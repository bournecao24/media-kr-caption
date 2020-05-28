from requests_html import HTMLSession;

class SimpleCrawlerV:
    def crawlV(self, params=None):
        session = HTMLSession();
        url = 'https://www.jianshu.com/p/85f4624485b9'
        r = session.get(url)
        print(r.html.text)

if __name__ == '__main__':
    SimpleCrawlerV().SimpleCrawlerV()


