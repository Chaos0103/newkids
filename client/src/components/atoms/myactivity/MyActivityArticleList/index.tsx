import React from 'react';
import { MyActivityArticleListWrapper } from './style';
import articleImage from '../../../../assets/imgs/profile-level.png';

function MyActivityArticleList() {
	// const [currentPage, setCurrentPage] = useState(1);

	const articleData = [
		{ title: '기사 제목 1', image: articleImage },
		{ title: '기사 제목 2', image: articleImage },
		{ title: '기사 제목 3', image: articleImage },
		{ title: '기사 제목 4', image: articleImage },
		{ title: '기사 제목 5', image: articleImage },
		{ title: '기사 제목 6', image: articleImage },
		{ title: '기사 제목 7', image: articleImage },
		{ title: '기사 제목 8', image: articleImage },
	];

	const renderArticleItems = () => {
		return articleData.map((item) => {
			return (
				<div className="article-list-text" key={item.title}>
					<img src={item.image} alt="" />
					<p>{item.title}</p>
				</div>
			);
		});
	};

	return <MyActivityArticleListWrapper>{renderArticleItems()}</MyActivityArticleListWrapper>;
}

export default MyActivityArticleList;
