import AreaTitle from 'components/atoms/common/AreaTitle';
import KeywordCloud from 'components/organisms/article/KeywordCloud';
import PopularArticleList from 'components/organisms/article/PopularArticleList';
import RecommendedArticleList from 'components/organisms/article/RecommendedArticleList';
import TrendingKeywordList from 'components/organisms/article/TrendingKeywordList';
import Footer from 'components/organisms/common/Footer';
import PageLayout from 'layouts/common/PageLayout';
import IndexPageLayout from 'layouts/page/IndexPageLayout';
import React from 'react';

function IndexPage() {
	return (
		<PageLayout>
			<IndexPageLayout
				PopularArticleList={
					<>
						<AreaTitle title="인기있는 기사" />
						<PopularArticleList />
					</>
				}
				TrendingKeywordList={
					<>
						<AreaTitle title="급상승 키워드" />
						<TrendingKeywordList />
					</>
				}
				RecommendedArticleList={
					<>
						<AreaTitle title="내 또래가 많이 접한 기사에요" />
						<RecommendedArticleList />
					</>
				}
				WordCloud={
					<>
						<AreaTitle title="이주의 핫이슈" />
						<KeywordCloud />
					</>
				}
				Footer={<Footer />}
			/>
		</PageLayout>
	);
}

export default IndexPage;
