import styled from 'styled-components';

export const WordListItemWrapper = styled.div`
	.word-list-item {
		height: 100%;
		display: flex;
		justify-content: space-evenly;
		> svg {
			height: 24px;
			width: 24px;
			fill: var(--danger-color);
		}
	}
`;
