/* eslint-disable react/no-danger */
import { NarrowContentLayout } from 'layouts/common/ContentLayout';
import React from 'react';
import { ArticleContentContainer } from './style';
import Dictionary from '../Dictionary';

interface IArticleContentProps {
	content: string;
}
function ArticleContent(props: IArticleContentProps) {
	const { content } = props;
	return (
		<ArticleContentContainer>
			<NarrowContentLayout>
				<div dangerouslySetInnerHTML={{ __html: content }} />
			</NarrowContentLayout>
			<Dictionary />
		</ArticleContentContainer>
	);
}

export default ArticleContent;
