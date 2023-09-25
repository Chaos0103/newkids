import React from 'react';
import { ReactComponent as View } from 'assets/icons/view.svg';
import { dateArrToString } from 'utils/common/dateArrToString';
import { ArticleHeaderContainer } from './style';

interface IArticleHeaderProps {
	title: string;
	writer: string;
	publishedDate: [number, number, number, number, number, number, number] | null;
	count: number;
}
function ArticleHeader(props: IArticleHeaderProps) {
	const { title, writer, publishedDate, count } = props;
	return (
		<ArticleHeaderContainer>
			<h1 className="title">{title}</h1>
			<div className="info">
				<p>{writer} 기자</p>
				<div className="right">
					<p className="view">
						<View />
						{count}
					</p>
					<p>{publishedDate ? dateArrToString(publishedDate) : '1970.01.01 00:00:00'}</p>
				</div>
			</div>
		</ArticleHeaderContainer>
	);
}

export default ArticleHeader;
