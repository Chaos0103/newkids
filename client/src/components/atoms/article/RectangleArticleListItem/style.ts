import styled from 'styled-components';

export const RectangleArticleListItemContainer = styled.div`
	display: flex;
	flex-direction: row;
	gap: 1rem;

	img {
		border-radius: var(--radius-m);
		width: 200px;
		height: 150px;
	}

	.content {
		width: 100%;
		display: flex;
		flex-direction: column;
		justify-content: space-around;

		h3 {
			font-size: 1.3rem;
			font-weight: bold;
			white-space: normal;
			display: -webkit-box;
			-webkit-line-clamp: 2;
			-webkit-box-orient: vertical;
			overflow: hidden;
		}

		.article-info {
		}
	}
`;
