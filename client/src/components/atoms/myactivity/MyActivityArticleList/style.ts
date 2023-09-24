import styled from 'styled-components';

export const MyActivityArticleListWrapper = styled.div`
	width: 100%;
	height: 100%;

	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
	align-content: flex-start;

	.article-list-text {
		width: calc(25% - 10px);
		margin-bottom: 10px;
		img {
			height: 150px;
			widht: 250px;
		}
	}
`;
