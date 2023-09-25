import MyPageMenu from 'components/organisms/common/MyPageMenu';
import MyCollectionArticle from 'components/organisms/mycollection/MyCollectionArticle';
import UserProfile from 'components/organisms/mypage/UserProfile';
import PageLayout from 'layouts/common/PageLayout';
import MyCollectionLayout from 'layouts/page/MyCollectionLayout';
import React from 'react';

function MyCollection() {
	return (
		<PageLayout>
			<MyCollectionLayout
				MyPageMenu={<MyPageMenu />}
				UserProfile={<UserProfile />}
				MyCollectionArticle={<MyCollectionArticle />}
			/>
		</PageLayout>
	);
}

export default MyCollection;
