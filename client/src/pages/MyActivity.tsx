import React from 'react';
import PageLayout from 'layouts/common/PageLayout';
import MyActivityLayout from 'layouts/page/MyActivityLayout';
import MyActivityChart from 'components/organisms/myactivity/MyActivityChart';
import MyActivityArticle from 'components/organisms/myactivity/MyActivityArticle';
import MyPageMenu from 'components/organisms/common/MyPageMenu';
import UserProfile from 'components/organisms/mypage/UserProfile';

function MyPage() {
	return (
		<PageLayout>
			<MyActivityLayout
				UserProfile={<UserProfile />}
				MyPageMenu={<MyPageMenu />}
				MyActivityChart={<MyActivityChart />}
				MyActivityArticle={<MyActivityArticle />}
			/>
		</PageLayout>
	);
}

export default MyPage;
