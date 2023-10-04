import React from 'react';
import useMovePage from 'hooks/useMovePage';
import { IMyArticleDetail } from 'types/article';
import { MyActivityArticleListWrapper } from './style';
import articleImage from '../../../../assets/imgs/noimg.jpg';

interface IMyActivityArticleListProps {
	articles: IMyArticleDetail[];
}

function MyActivityArticleList(props: IMyActivityArticleListProps) {
	const { articles } = props;

	const [movePage] = useMovePage();

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

	return <MyActivityArticleListWrapper>{renderArticleItems()}</MyActivityArticleListWrapper>;
}

export default MyActivityArticleList;
