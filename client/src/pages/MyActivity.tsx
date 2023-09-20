import React from 'react';
import PageLayout from 'layouts/common/PageLayout';
import MyActivityLayout from 'layouts/page/MyActivityLayout';
import MyActivityChart from 'components/organisms/myactivity/MyActivityChart';
import MyActivityArticle from 'components/organisms/myactivity/MyActivityArticle';
import MyPageMenu from 'components/organisms/common/MyPageMenu';

function MyPage() {
	return (
		<PageLayout>
			<MyActivityLayout
				MyPageMenu={<MyPageMenu />}
				MyActivityChart={<MyActivityChart />}
				MyActivityArticle={<MyActivityArticle />}
			/>
		</PageLayout>
	);
}

export default MyPage;
