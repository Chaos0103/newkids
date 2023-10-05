import React, { useState } from 'react';
import useMovePage from 'hooks/useMovePage';
import { IMyArticleDetail } from 'types/article';
import articleImage from 'assets/imgs/noimg.jpg';
import { MyActivityArticleListWrapper } from './style';

interface IMyActivityArticleListProps {
	articles: IMyArticleDetail[];
}

function MyActivityArticleList(props: IMyActivityArticleListProps) {
	const { articles } = props;

	const [movePage] = useMovePage();

	const [isHovered, setIsHovered] = useState(false);
	const [popupText, setPopupText] = useState('');

	const handleMouseEnter = (item: IMyArticleDetail) => {
		setPopupText(item.title);
		setIsHovered(true);
	};

	const handleMouseLeave = () => {
		setIsHovered(false);
		setPopupText('');
	};

	const renderArticleItems = () => {
		return articles.map((item) => {
			const truncatedTitle = item.title.length > 15 ? `${item.title.slice(0, 11)}...` : item.title;
			return (
				<div
					className="article-list-text"
					key={item.articleId}
					onMouseEnter={() => handleMouseEnter(item)}
					onMouseLeave={handleMouseLeave}
				>
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
						{truncatedTitle}
					</p>
					{isHovered && (
						<div className="popup-text" style={{ display: 'block' }}>
							{popupText}
						</div>
					)}
				</div>
			);
		});
	};

	return <MyActivityArticleListWrapper>{renderArticleItems()}</MyActivityArticleListWrapper>;
}

export default MyActivityArticleList;
