import styled from 'styled-components';

export const CheckTextButtonWrapper = styled.div<{ value: boolean }>`
	gap: 5px;

	button {
		display: flex;
		flex-direction: row;
		align-items: center;
		gap: 5px;
		color: ${({ value }) => (value ? 'var(--sub-color-1' : 'var(--gray-300)')};

		svg {
			fill: ${({ value }) => (value ? 'var(--sub-color-1' : 'var(--gray-300)')};
		}
	}
`;
