import React from 'react';
import MyCollectionArticleList from 'components/atoms/mycollection/MyCollectionArticleList';
import { MyCollectionArticleContainer } from './style';

function MyCollectionArticle() {
	return (
		<MyCollectionArticleContainer>
			<div className="collection-title">
				<p className="gray-color-text">내가&nbsp;</p>
				<p className="sub-color-text">모은 기사</p>
				<p className="gray-color-text">에요</p>
			</div>
			<div className="collection-list-box">
				<MyCollectionArticleList />
			</div>
		</MyCollectionArticleContainer>
	);
}

export default MyCollectionArticle;
