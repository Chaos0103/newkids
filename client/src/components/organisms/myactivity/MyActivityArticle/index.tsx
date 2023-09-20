import React from 'react';
import MyActivityArticleList from 'components/atoms/myactivity/MyActivityArticleList';
import { MyActivityArticleContainer } from './styles';

function MyActivityArticle() {
	return (
		<MyActivityArticleContainer>
			<div className="article-title-text">
				<p className="gray-color-text">내가&nbsp;</p>
				<p className="sub-color-text">최근 본 기사</p>
				<p className="gray-color-text">에요</p>
			</div>
			<div className="article-list-box">
				<MyActivityArticleList />
			</div>
		</MyActivityArticleContainer>
	);
}

export default MyActivityArticle;
