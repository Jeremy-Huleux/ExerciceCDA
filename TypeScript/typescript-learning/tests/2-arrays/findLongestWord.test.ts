import { describe, it, expect } from 'vitest'
import { findLongestWord } from '../../functions/2-arrays'

describe('findLongestWord', () => {
  it('retourne une chaîne de caractères', () => {
    expect(typeof findLongestWord(['a', 'b', 'c'])).toBe('string')
  })

  it('retourne le mot le plus long du tableau', () => {
    const words = [
      'bumbling',
      'semiprecious',
      'discombobulated',
      'aaaaaa',
      'giraffe',
      'numbskull',
    ]
    expect(findLongestWord(words)).toBe('discombobulated')
  })
})
