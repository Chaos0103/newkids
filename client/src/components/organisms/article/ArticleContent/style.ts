import styled from 'styled-components';

export const ArticleContentContainer = styled.div`
	position: relative;
	min-height: calc(200vh - 76px);
	display: flex;
	justify-content: space-between;
	gap: 10px;

	& > div:nth-child(1) {
		margin: 0;
		background-color: var(--gray-200);
	}
`;
