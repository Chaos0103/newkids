import styled from 'styled-components';

export const PeriodFilterItemWrapper = styled.div<{ $isSelected: boolean }>`
	border: 2px solid ${({ $isSelected }) => ($isSelected ? 'var(--main-color)' : 'var(--gray-300)')};
	padding: 0.5rem 1rem;
	border-radius: var(--radius-l);
	width: 75px;
	text-align: center;
	font-weight: bold;
	color: ${({ $isSelected }) => ($isSelected ? 'var(--main-color)' : 'var(--gray-300)')};

	&:hover {
		cursor: pointer;
	}
`;
