import urllib2


# 把传递解析函数，便于下面的修改
class SimpleCrawlerV2:

    def get_html(url, paraser=bs4_paraser):
        headers = {
            'Accept': '*/*',
            'Accept-Encoding': 'gzip, deflate, sdch',
            'Accept-Language': 'zh-CN,zh;q=0.8',
            'Host': 'www.360kan.com',
            'Proxy-Connection': 'keep-alive',
            'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36'
        }
        request = urllib2.Request(url, headers=headers)
        response = urllib2.urlopen(request)
        response.encoding = 'utf-8'
        if response.code == 200:
            data = StringIO.StringIO(response.read())
            gzipper = gzip.GzipFile(fileobj=data)
            data = gzipper.read()
            value = paraser(data)  # open('E:/h5/haPkY0osd0r5UB.html').read()
            return value
        else:
            pass

    def bs4_paraser(html):
        all_value = []
        value = {}
        soup = BeautifulSoup(html, 'html.parser')
        # 获取影评的部分
        all_div = soup.find_all('div', attrs={'class': 'yingping-list-wrap'}, limit=1)
        for row in all_div:
            # 获取每一个影评，即影评的item
            all_div_item = row.find_all('div', attrs={'class': 'item'})
            for r in all_div_item:
                # 获取影评的标题部分
                title = r.find_all('div', attrs={'class': 'g-clear title-wrap'}, limit=1)
                if title is not None and len(title) > 0:
                    value['title'] = title[0].a.string
                value['title_href'] = title[0].a['href']
                score_text = title[0].div.span.span['style']
                score_text = re.search(r'\d+', score_text).group()
                value['score'] = int(score_text) / 20
                # 时间
                value['time'] = title[0].div.find_all('span', attrs={'class': 'time'})[0].string
                # 多少人喜欢
                value['people'] = int(
                    re.search(r'\d+', title[0].find_all('div', attrs={'class': 'num'})[0].span.string).group())
            # print r
            all_value.append(value)
            value = {}
        return all_value


value = get_html('http://www.360kan.com/m/haPkY0osd0r5UB.html', paraser=lxml_parser)
for row in value:
    print row
