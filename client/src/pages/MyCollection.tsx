import MyPageMenu from 'components/organisms/common/MyPageMenu';
import MyCollectionArticle from 'components/organisms/mycollection/MyCollectionArticle';
import PageLayout from 'layouts/common/PageLayout';
import MyCollectionLayout from 'layouts/page/MyCollectionLayout';
import React from 'react';

function MyCollection() {
	return (
		<PageLayout>
			<MyCollectionLayout MyPageMenu={<MyPageMenu />} MyCollectionArticle={<MyCollectionArticle />} />
		</PageLayout>
	);
}

export default MyCollection;
