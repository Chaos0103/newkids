import React, { useEffect, useState } from 'react';
import { findAllReadArticleApi } from 'utils/apis/article';
import { DUMMY_ARTICLES } from 'constants/dummyreadarticle';
import useMovePage from 'hooks/useMovePage';
import { MyActivityArticleListWrapper } from './style';
import articleImage from '../../../../assets/imgs/profile-level.png';

function MyActivityArticleList() {
	// const [currentPage, setCurrentPage] = useState(1);
	const [articles, setArticles] = useState(DUMMY_ARTICLES);
	// const [pageNum, setPageNum] = useState(1);
	const pageNum = 2;

	const [movePage] = useMovePage();

	const ReadArticleData = async () => {
		try {
			const memberkey = localStorage.getItem('memberkey');
			if (memberkey) {
				const response = await findAllReadArticleApi(memberkey, pageNum);
				console.log(response);
			}
		} catch (e) {
			console.log(e);
		}
	};

	const renderArticleItems = () => {
		return articles.map((item) => {
			return (
				<div className="article-list-text" key={item.articleId}>
					{item.thumbnailImg && (
						<img
							src={item.thumbnailImg}
							alt=""
							onClick={() => movePage(`/article/${item.articleId}`)}
							role="presentation"
						/>
					)}

					{!item.thumbnailImg && <img src={articleImage} alt="" />}
					<p onClick={() => movePage(`/article/${item.articleId}`)} role="presentation">
						{item.title}
					</p>
				</div>
			);
		});
	};

	useEffect(() => {
		setArticles(DUMMY_ARTICLES);
		ReadArticleData();
	}, []);

	return <MyActivityArticleListWrapper>{renderArticleItems()}</MyActivityArticleListWrapper>;
}

export default MyActivityArticleList;
